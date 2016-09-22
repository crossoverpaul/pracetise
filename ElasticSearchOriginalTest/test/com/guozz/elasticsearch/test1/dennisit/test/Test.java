package com.guozz.elasticsearch.test1.dennisit.test;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import com.guozz.elasticsearch.test1.dennisit.data.Medicine;
import com.guozz.elasticsearch.test1.dennisit.process.ElasticSearchHandler;

/**
 * @author guozhizhong
 * @version 2016-09-22 11:09:17
 */
public class Test {

	@org.junit.Test
	public void testBulkInput (){
		 ElasticSearchHandler esHandler = new ElasticSearchHandler();
		 try {
			esHandler.BulkInput();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@org.junit.Test
	public void testQuery (){
		 ElasticSearchHandler esHandler = new ElasticSearchHandler();
		  QueryBuilder queryBuilder = QueryBuilders.matchQuery("name", "感冒"); //fieldQuery("name", "感冒");
	        List<Medicine> result = esHandler.searcher(queryBuilder, "indexdemo", "typedemo");
	        for(int i=0; i<result.size(); i++){
	            Medicine medicine = result.get(i);
	            System.out.println("(" + medicine.getId() + ")药品名称:" +medicine.getName() + "\t\t" + medicine.getFunction());
	        }
	 
	}
	
	@org.junit.Test
	public void testDeleteById (){
		 ElasticSearchHandler esHandler = new ElasticSearchHandler();
		 esHandler.deleteById("indexdemo", "typedemo", "1");
	 
	}
	
	@org.junit.Test
	public void testDeleteByCondition (){
		 ElasticSearchHandler esHandler = new ElasticSearchHandler();
		 esHandler.deleteByCondition("indexdemo", "typedemo", QueryBuilders.boolQuery()
			        .must(QueryBuilders.matchQuery("id", 2)));
	}
}
