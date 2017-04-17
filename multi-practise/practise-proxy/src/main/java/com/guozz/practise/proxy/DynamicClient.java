package com.guozz.practise.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/4/17.
 */
public class DynamicClient {
    public static void main(String[] args){
        Humen humen = new HumenImpl();

        DynamicProxy dynamicProxy = new  DynamicProxy(humen);
//        Humen humenProxy = (Humen) Proxy.newProxyInstance(
//                humen.getClass().getClassLoader(),
//                humen.getClass().getInterfaces(),
//                dynamicProxy);
        Humen humenProxy = dynamicProxy.getProxy();
        humenProxy.eat("rice");
    }

}
