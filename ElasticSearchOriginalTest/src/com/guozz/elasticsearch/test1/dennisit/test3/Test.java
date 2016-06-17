package com.guozz.elasticsearch.test1.dennisit.test3;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.highlight.HighlightField;

import com.guozz.elasticsearch.test1.dennisit.cluster.ESClient;

public class Test {

	public void search() throws IOException {
        // 自定义集群结点名称
        String clusterName = "elasticsearch_pudongping";

        // 获取客户端
        Client client = ESClient.initClient(clusterName);

        // 创建查询索引,参数productindex表示要查询的索引库为productindex
        SearchRequestBuilder searchRequestBuilder = client
                .prepareSearch("productindex");

        // 设置查询索引类型,setTypes("productType1", "productType2","productType3");
        // 用来设定在多个类型中搜索
        searchRequestBuilder.setTypes("productIndex");

        // 设置查询类型 1.SearchType.DFS_QUERY_THEN_FETCH = 精确查询 2.SearchType.SCAN =
        // 扫描查询,无序
        searchRequestBuilder.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);

        // 设置查询关键词
        searchRequestBuilder
                .setQuery(QueryBuilders.matchQuery("title", "Acer"));

        // 查询过滤器过滤价格在4000-5000内 这里范围为[4000,5000]区间闭包含,搜索结果包含价格为4000和价格为5000的数据
        searchRequestBuilder.setPostFilter(FilterBuilders.rangeFilter("price")
                .from(4000).to(5000));

        // 分页应用
        searchRequestBuilder.setFrom(0).setSize(60);

        // 设置是否按查询匹配度排序
        searchRequestBuilder.setExplain(true);

        // 执行搜索,返回搜索响应信息
        SearchResponse response = searchRequestBuilder.execute().actionGet();

        SearchHits searchHits = response.getHits();
        SearchHit[] hits = searchHits.getHits();
        for (int i = 0; i < hits.length; i++) {
            SearchHit hit = hits[i];
            Map<String, Object> result = hit.getSource();
            // 打印map集合:{id=26, onSale=true, title=宏基Acer乐3, price=4009.0,
            // description=null, createDate=1380530123140, type=2}
            System.out.println(result);
        }
        System.out.println("search success ..");

    }
	
	public void searchHighLight() throws IOException {
        // 自定义集群结点名称
        String clusterName = "elasticsearch_pudongping";
        
        // 获取客户端
        Client client = ESClient.initClient(clusterName);    

        // 创建查询索引,参数productindex表示要查询的索引库为productindex
        SearchRequestBuilder searchRequestBuilder = client
                .prepareSearch("productindex");

        // 设置查询索引类型,setTypes("productType1", "productType2","productType3");
        // 用来设定在多个类型中搜索
        searchRequestBuilder.setTypes("productIndex");

        // 设置查询类型 1.SearchType.DFS_QUERY_THEN_FETCH = 精确查询 2.SearchType.SCAN = 扫描查询,无序
        searchRequestBuilder.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);

        // 设置查询关键词
        searchRequestBuilder
                .setQuery(QueryBuilders.matchQuery("title", "Acer"));

        // 查询过滤器过滤价格在4000-5000内 这里范围为[4000,5000]区间闭包含,搜索结果包含价格为4000和价格为5000的数据
        searchRequestBuilder.setPostFilter(FilterBuilders.rangeFilter("price")
                .from(4000).to(5000));

        // 分页应用
        searchRequestBuilder.setFrom(0).setSize(60);

        // 设置是否按查询匹配度排序
        searchRequestBuilder.setExplain(true);
        
        //设置高亮显示
        searchRequestBuilder.addHighlightedField("title");
        searchRequestBuilder.setHighlighterPreTags("<span style=\"color:red\">");
         searchRequestBuilder.setHighlighterPostTags("</span>");
        // 执行搜索,返回搜索响应信息
        SearchResponse response = searchRequestBuilder.execute().actionGet();
        
        //获取搜索的文档结果
        SearchHits searchHits = response.getHits();
        SearchHit[] hits = searchHits.getHits();
        ObjectMapper mapper = new ObjectMapper();
        for (int i = 0; i < hits.length; i++) {
            SearchHit hit = hits[i];
            //将文档中的每一个对象转换json串值
            String json = hit.getSourceAsString();
            //将json串值转换成对应的实体对象
            Product product = mapper.readValue(json, Product.class);  
            
            //获取对应的高亮域
            Map<String, HighlightField> result = hit.highlightFields();    
            //从设定的高亮域中取得指定域
            HighlightField titleField = result.get("title");  
            //取得定义的高亮标签
            Text[] titleTexts =  titleField.fragments();    
            //为title串值增加自定义的高亮标签
            String title = "";  
            for(Text text : titleTexts){    
                  title += text;  
            }
            //将追加了高亮标签的串值重新填充到对应的对象
            product.setTitle(title);
            //打印高亮标签追加完成后的实体对象
            System.out.println(product);
        }
        System.out.println("search success ..");

    }
}
