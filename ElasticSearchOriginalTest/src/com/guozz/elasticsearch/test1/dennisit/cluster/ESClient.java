package com.guozz.elasticsearch.test1.dennisit.cluster;


import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.elasticsearch.action.get.GetResponse;
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

/**
 * description:
 *
 * @author <a href='mailto:dennisit@163.com'> Cn.pudp (En.dennisit)</a> Copy Right since 2013-9-29 
 *
 * com.bbf.client.ESClient.java
 *
 */

public class ESClient {

    
    /**在运行该测试实例时,已经在本地建立了对应的索引库datum*/
    public static void main(String[] args) {
        
        
        //自定义集群结点名称
        String clusterName = "elasticsearch_pudongping"; 
        
        //程序中更改集群结点名称 并且设置client.transport.sniff为true来使客户端去嗅探整个集群的状态
        Settings settings = ImmutableSettings.settingsBuilder()
        .put("cluster.name", clusterName).put("client.transport.sniff", true).build();   
        
        //创建客户端对象
        TransportClient client = new TransportClient(settings);
        
        //客户端对象初始化集群内结点,绑定多个ip
        //client.addTransportAddress(new InetSocketTransportAddress("192.168.0.149", 9300));
        client.addTransportAddress(new InetSocketTransportAddress("192.168.0.162", 9300));
        
        
        //搜索,根据Id查询
        GetResponse response = client.prepareGet("datum", "datum", ""+130)
          .execute()
          .actionGet();
        
        //查询结果映射成对象类
        ObjectMapper mapper = new ObjectMapper();
        Datum datum= mapper.convertValue(response.getSource(), Datum.class);
        
        System.out.println("资讯编号:" + datum.getId() +"\t资讯标题:"+datum.getTitle()  );
        
        //构造查询器查询,第一个参数为要查询的关键字,第二个参数为要检索的索引库中的对应索引类型的域
        QueryBuilder query = QueryBuilders.multiMatchQuery("恩必普", "keyword");  
        //第一个参数datum表示索引库,第二个参数datum表示索引类型,from表示开始的位置 size表示查询的条数 ,类似mysql中的limit3,5
        SearchResponse searchResponse = client.prepareSearch("datum").setTypes("datum").setQuery(query).setFrom(3).setSize(5).execute().actionGet(); 
        
 
        //将搜索结果转换为list集合对象
        List<Datum> lists  = getBeans(searchResponse);
        
        System.out.println("查询出来的结果数:" + lists.size());
        for(Datum dtm: lists){
            System.out.println("资讯编号:" + dtm.getId() +"\t资讯标题:"+dtm.getTitle());
        }
        
        //关闭客户端
        client.close();    

    }
    
    /**
     * 从查询到的记录中获取json串值,转换成<code>Datum</code>对象
     *
     * @author <a href='mailto:dennisit@163.com'> Cn.pudp (En.dennisit)</a> Copy Right since 2013-9-24 下午09:24:29
     *                
     * @param response
     *                     查询结果集<code>GetResponse</code>
     * @return
     *                     返回<code>Datum</code>对象
     */
    public static Datum getResponseToObject(GetResponse response){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(response.getSource(), Datum.class);
    }
    
    
    /**
     * 将查询到的对象集合封装成List集合
     *
     * @author <a href='mailto:dennisit@163.com'>Cn.pudp(En.dennisit)</a> Copy Right since 2013-9-27 下午02:31:26
     *                
     * @param  response
     * @return
     */
    public static List<Datum> getBeans(SearchResponse response) {
        SearchHits hits = response.getHits();
        ObjectMapper mapper = new ObjectMapper();
        List<Datum> datumList = new ArrayList<Datum>();
        for (SearchHit hit : hits) {  
            String json = hit.getSourceAsString();
            Datum dtm = new Datum();
           
            try {
                dtm = mapper.readValue(json, Datum.class);
                datumList.add(dtm);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        return datumList;
    }

	public static Client initClient(String clusterName) {
		 Settings settings = ImmutableSettings.settingsBuilder().put("cluster.name", clusterName).put("client.transport.ping_timeout", "10s").build();
		 Client  client = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress("127.0.0.1", 8300));
		return client;
	}
    
}
