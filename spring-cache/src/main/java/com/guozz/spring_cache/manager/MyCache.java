package com.guozz.spring_cache.manager;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import com.guozz.spring_cache.domain.Account;

/**
 * @author guozhizhong
 * @version 2016-12-21 11:11:58
 */
public class MyCache implements Cache {

	   private String name;
	   
	   private Map<String,Account> store = new HashMap<String,Account>();
	   
	   public MyCache() { 
	   } 
	   
	   public MyCache(String name) { 
	     this.name = name; 
	   } 
	
	/* (non-Javadoc)
	 * @see org.springframework.cache.Cache#getName()
	 */
	public String getName() {
		// TODO Auto-generated method stub
		   return name; 
	}
	
	   public void setName(String name) { 
		     this.name = name; 
		   } 

	/* (non-Javadoc)
	 * @see org.springframework.cache.Cache#getNativeCache()
	 */
	public Object getNativeCache() {
		// TODO Auto-generated method stub
		  return store; 
	}

	/* (non-Javadoc)
	 * @see org.springframework.cache.Cache#get(java.lang.Object)
	 */
	public ValueWrapper get(Object key) {
		// TODO Auto-generated method stub
		 ValueWrapper result = null; 
	     Account thevalue = store.get(key); 
	     if(thevalue!=null) { 
	       thevalue.setPassword("from mycache:"+name); 
	       result = new SimpleValueWrapper(thevalue); 
	     } 
	     return result; 
	}

	/* (non-Javadoc)
	 * @see org.springframework.cache.Cache#get(java.lang.Object, java.lang.Class)
	 */
	public <T> T get(Object key, Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.cache.Cache#put(java.lang.Object, java.lang.Object)
	 */
	public void put(Object key, Object value) {
		// TODO Auto-generated method stub
		  Account thevalue = (Account)value; 
		  store.put((String)key, thevalue); 
	}

	/* (non-Javadoc)
	 * @see org.springframework.cache.Cache#putIfAbsent(java.lang.Object, java.lang.Object)
	 */
	public ValueWrapper putIfAbsent(Object key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.cache.Cache#evict(java.lang.Object)
	 */
	public void evict(Object key) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.springframework.cache.Cache#clear()
	 */
	public void clear() {
		// TODO Auto-generated method stub

	}

}
