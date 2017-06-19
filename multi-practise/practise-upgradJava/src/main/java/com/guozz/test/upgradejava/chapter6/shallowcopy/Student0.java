package com.guozz.test.upgradejava.chapter6.shallowcopy;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-6-16
 * Time: 上午9:41
 * To change this template use File | Settings | File Templates.
 */
public class Student0 implements Cloneable {

     String name;

     int age;

    Professor0 professor0;

    public Student0(String name, int age, Professor0 professor0) {
        this.name = name;
        this.age = age;
        this.professor0 = professor0;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student0 o = null;
        try {
            o = (Student0) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        return o;
    }
}
