package com.guozz.test.upgradejava.chapter6.deepcopy;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-6-16
 * Time: 上午9:40
 * To change this template use File | Settings | File Templates.
 */
public class Professor implements Cloneable{

     String name;

     int age;

    public Professor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        return o;
    }
}
