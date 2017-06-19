package com.guozz.test.upgradejava.chapter6.deepcopy;

import com.guozz.test.upgradejava.chapter6.shallowcopy.Professor0;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-6-16
 * Time: 上午9:41
 * To change this template use File | Settings | File Templates.
 */
public class Student implements Cloneable {

     String name;

     int age;

    Professor professor;

    public Student(String name, int age, Professor professor) {
        this.name = name;
        this.age = age;
        this.professor = professor;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student o = null;
        try {
            o = (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        o.professor= (Professor) professor.clone();
        return o;
    }
}
