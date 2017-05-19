package com.guozz.test.spring.interfaces.aop.impl;

import com.guozz.test.spring.interfaces.aop.IHelloWorldService;

/** 
 * @Author guozz 【guozhizhong@le.com】
 * @Date 2017/5/16  10:15
 */
public class HelloWorldService implements IHelloWorldService {

    public void sayHello() {
        System.out.println("Hello World!");
    }

}
