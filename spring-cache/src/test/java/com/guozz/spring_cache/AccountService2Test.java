package com.guozz.spring_cache;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.guozz.spring_cache.service.AccountService2;

/**
 * @author guozhizhong
 * @version 2016-12-21 10:14:37
 */
public class AccountService2Test {

	  private AccountService2 accountService2;
	  
	  private final Logger logger = LoggerFactory.getLogger(AccountService2.class);
	  
	  
	  @Before
	    public void setUp() throws Exception {
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config-service.xml");
	        accountService2 = context.getBean("accountService2", AccountService2.class);
	    }
	 
	    @Test
	    public void testInject(){
	        assertNotNull(accountService2);
	    }
	 
	    @Test
	    public void testGetAccountByName() throws Exception {
	        logger.info("first query...");
	        accountService2.getAccountByName("accountName");
	 
	        logger.info("second query...");
	        accountService2.getAccountByName("accountName");
	    }
	  
}
