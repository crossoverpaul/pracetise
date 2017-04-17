package com.guozz.practise.proxy;

/**
 * Created by Administrator on 2017/4/17.
 */
public class Client {

    public static void main(String[] args){
        Humen humenProxy = new HumenProxy();
        humenProxy.eat("rice");
    }
}
