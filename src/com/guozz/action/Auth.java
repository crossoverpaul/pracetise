package com.guozz.action;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//表示在什么级别保存该注解信息  
@Retention(RetentionPolicy.RUNTIME)  
//表示该注解用于什么地方  
@Target(ElementType.METHOD)  
public @interface Auth {

	 String actionName();  
	 String privilege();  
}
