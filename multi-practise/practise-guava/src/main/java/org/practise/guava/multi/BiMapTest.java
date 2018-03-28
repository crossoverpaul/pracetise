package org.practise.guava.multi;

import org.junit.Test;

import com.google.common.collect.*;

public class BiMapTest {

	@Test
    public void BimapTest(){
        BiMap<Integer,String> logfileMap = HashBiMap.create(); 
        logfileMap.put(1,"a.log");
        logfileMap.put(2,"b.log");
        logfileMap.put(3,"c.log"); 
        System.out.println("logfileMap:"+logfileMap); 
        BiMap<String,Integer> filelogMap = logfileMap.inverse();
        System.out.println("filelogMap:"+filelogMap);
    }
	
	
	@Test
    public void BimapTest2(){
        BiMap<Integer,String> logfileMap = HashBiMap.create(); 
        logfileMap.put(1,"a.log");
        logfileMap.put(2,"b.log");
        logfileMap.put(3,"c.log");         
        logfileMap.put(4,"d.log"); 
        logfileMap.put(5,"d.log"); 
    }
}
