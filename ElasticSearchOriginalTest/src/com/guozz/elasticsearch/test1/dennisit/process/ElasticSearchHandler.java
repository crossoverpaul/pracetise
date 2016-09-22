package com.guozz.elasticsearch.test1.dennisit.process;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.deletebyquery.DeleteByQueryResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

import com.guozz.elasticsearch.test1.dennisit.data.DataFactory;
import com.guozz.elasticsearch.test1.dennisit.data.Medicine;
import com.guozz.elasticsearch.test1.dennisit.util.JsonUtil;

public class ElasticSearchHandler {

	private Client client;

    public ElasticSearchHandler(){    
        //使用本机做为节点
        this("127.0.0.1");
    }
    
    public ElasticSearchHandler(String ipAddress){
        //集群连接超时设置
        Settings settings = ImmutableSettings.settingsBuilder().put("cluster.name", "cupid-es").put("client.transport.ping_timeout", "10s").build();
        client = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress(ipAddress, 8300));
    }
    
    
    /**
     * 建立索引,索引建立好之后,会在elasticsearch-0.20.6\data\elasticsearch\nodes\0创建所以你看
     * @param indexName  为索引库名，一个es集群中可以有多个索引库。 名称必须为小写
     * @param indexType  Type为索引类型，是用来区分同索引库下不同类型的数据的，一个索引库下可以有多个索引类型。
     * @param jsondata     json格式的数据集合
     * 
     * @return
     */
    public void createIndexResponse(String indexname, String type, List<String> jsondata){
    	//创建索引时判断此索引是否存在
    	if(isExistsIndex(indexname)){
    		  DeleteIndexResponse deleteIndexResponse = client.admin().indices()    
                      .prepareDelete(indexname)    
                      .execute().actionGet();    
    		  System.out.println(deleteIndexResponse.getHeaders());  
    	}
        //创建索引库 需要注意的是.setRefresh(true)这里一定要设置,否则第一次建立索引查找不到数据
        IndexRequestBuilder requestBuilder = client.prepareIndex(indexname, type).setRefresh(true);
        for(int i=0; i<jsondata.size(); i++){
            requestBuilder.setSource(jsondata.get(i)).execute().actionGet();
        }     
         
    }
    
    
    /**
     * 判断指定的索引的类型是否存在
     * @param indexName 索引名
     * @param indexType 索引类型
     * @return  存在：true; 不存在：false;
     */
    public boolean isExistsType(String indexName,String indexType){
        TypesExistsResponse  response = 
        		client.admin().indices()
                .typesExists(new TypesExistsRequest(new String[]{indexName}, indexType)
                ).actionGet();
        System.out.println( JsonUtil.object2Json(response));
        return response.isExists();
    }
    
    /**
     * 判断指定的索引名是否存在
     * @param indexName 索引名
     * @return  存在：true; 不存在：false;
     */
    public boolean isExistsIndex(String indexName){
        IndicesExistsResponse  response = 
        		client.admin().indices().exists( 
                        new IndicesExistsRequest().indices(new String[]{indexName})).actionGet();
        System.out.println( JsonUtil.object2Json(response));
        return response.isExists();
}


	/**
     * 创建索引
     * @param client
     * @param jsondata
     * @return
     */
    public IndexResponse createIndexResponse(String indexname, String type,String jsondata){
        IndexResponse response = client.prepareIndex(indexname, type)
            .setSource(jsondata)
            .execute()
            .actionGet();
        return response;
    }
    
    /**
     * 执行搜索
     * @param queryBuilder
     * @param indexname
     * @param type
     * @return
     */
    public List<Medicine>  searcher(QueryBuilder queryBuilder, String indexname, String type){
        List<Medicine> list = new ArrayList<Medicine>();
        SearchResponse searchResponse = client.prepareSearch(indexname).setTypes(type)
        .setQuery(queryBuilder)
        .execute()
        .actionGet();
        SearchHits hits = searchResponse.getHits();
        System.out.println("查询到记录数=" + hits.getTotalHits());
        SearchHit[] searchHists = hits.getHits();
        if(searchHists.length>0){
            for(SearchHit hit:searchHists){
                Integer id = (Integer)hit.getSource().get("id");
                String name =  (String) hit.getSource().get("name");
                String function =  (String) hit.getSource().get("funciton");
                list.add(new Medicine(id, name, function));
            }
        }
        return list;
    }
    
    

    /**
     * 批量导入
     * @throws Exception
     */
	public void BulkInput() throws Exception {  
	    List<IndexRequest> requests = new ArrayList<IndexRequest>();  
	    for (int i = 0; i < 100000; i++) {  
	    	Medicine medicine = new Medicine();  
	    	medicine.setId(i+100);
	    	medicine.setName("name"+i);
	    	medicine.setFunction("function"+i);
	        String index = "indexdemo"; // 相当于数据库名  
	        String type = "typedemo"; // 相当于表名  
	  
	        String json =JsonUtil.object2Json(medicine);
	  
	        IndexRequest request = client  
	                .prepareIndex(index, type, medicine.getId()+"").setSource(json)  
	                .request();  
	        requests.add(request);  
	    }  
	  
	    BulkRequestBuilder bulkRequest = client.prepareBulk();  
	  
	    for (IndexRequest request : requests) {  
	        bulkRequest.add(request);  
	    }  
	  
	    BulkResponse bulkResponse = bulkRequest.execute().actionGet();  
	    //System.out.println(JsonUtil.object2Json(bulkResponse));
	    if (bulkResponse.hasFailures()) {  
	        System.out.println("批量创建索引错误！");  
	    }  
	} 
    
	/**
	 * 该方法是根据index、type、_Id三部分来进行记录的删除，但是在实际的操作过程中，该方法应用较少，主要是其_Id难以直接获取
	 * @param indexName
	 * @param indexType
	 * @param id
	 */
	public void deleteById(String indexName,String indexType,String id){
		DeleteResponse response = client
		        .prepareDelete(indexName, indexType, id)
		              .execute()
		              .actionGet();
		System.out.println(response.toString());
	}
	/**
	 * 该方法是根据查询的过程来进行的条件删除，可以具体指定查询条件，比较常用。
	 * @param indexName
	 * @param indexType
	 * @param id
	 */
	public void deleteByCondition(String indexName,String indexType,QueryBuilder queryBuilder){
		DeleteByQueryResponse response = client.prepareDeleteByQuery(indexName)
		        .setTypes(indexType)
		        .setQuery(queryBuilder)
		        .execute().actionGet();
		System.out.println(response.toString());
	}
	
    public static void main(String[] args) {
        ElasticSearchHandler esHandler = new ElasticSearchHandler();
        List<String> jsondata = DataFactory.getInitJsonData();
        String indexName = "indexdemo";
        String indexType = "typedemo";
        esHandler.createIndexResponse(indexName, indexType, jsondata);
        //查询条件
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("name", "感冒了"); //fieldQuery("name", "感冒");

        List<Medicine> result = esHandler.searcher(queryBuilder, indexName, indexType);
        for(int i=0; i<result.size(); i++){
            Medicine medicine = result.get(i);
            System.out.println("(" + medicine.getId() + ")药品名称:" +medicine.getName() + "\t\t" + medicine.getFunction());
        }
    }
}
