package com.guozz.practise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {

	public static void main(String[] args) {
		 Logger logger = LoggerFactory.getLogger(Test.class);
		 //logger.info("hello {}",new Date());
		 logger.info("测试slf4j,参数1{},参数2{},参数2{}",111,222,333);
		 logger.info("测试slf4j,参数1{},参数2{},参数2{}",new Object[]{444,555,666});
	}
}
