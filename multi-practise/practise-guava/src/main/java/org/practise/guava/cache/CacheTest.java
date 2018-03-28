package org.practise.guava.cache;

import org.junit.Test;

import com.google.common.cache.*;

public class CacheTest {

	@Test
    public void TestLoadingCache() throws Exception{
        LoadingCache<String,String> cahceBuilder=CacheBuilder
        .newBuilder()
        .build(new CacheLoader<String, String>(){
            @Override
            public String load(String key) throws Exception {        
                String strProValue="hello "+key+"!";                
                return strProValue;
            }
            
        });        
        
        System.out.println("jerry value:"+cahceBuilder.apply("jerry"));
        System.out.println("jerry value:"+cahceBuilder.get("jerry"));
        System.out.println("peida value:"+cahceBuilder.get("peida"));
        System.out.println("peida value:"+cahceBuilder.apply("peida"));
        System.out.println("lisa value:"+cahceBuilder.apply("lisa"));
        cahceBuilder.put("harry", "ssdded");
        System.out.println("harry value:"+cahceBuilder.get("harry"));
    }
}
