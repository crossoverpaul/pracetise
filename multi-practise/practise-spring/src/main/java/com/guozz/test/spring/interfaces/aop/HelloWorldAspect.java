package com.guozz.test.spring.interfaces.aop;

/** 
 * @Author guozz 【guozhizhong@le.com】
 * @Date 2017/5/16  10:19
 */

public class HelloWorldAspect {
    //前置通知
    public void beforeAdvice() {
        System.out.println("===========before advice");
    }
    //后置最终通知
    public void afterFinallyAdvice() {
        System.out.println("===========after finally advice");
    }
}
