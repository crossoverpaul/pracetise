package com.guozz.practise.proxy;

/**
 * Created by Administrator on 2017/4/17.
 */
public class HumenProxy implements Humen {

    private Humen humen;

    public HumenProxy(){
        humen = new HumenImpl();
    }

    public void eat(String food){
        before();
        humen.eat(food);
        after();
    }

    private void before(){
        System.out.println("cook");
    }

    private void after(){
        System.out.println("swap");
    }
}
