package com.guozz.test.upgradejava.chapter6.deepcopy;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-6-16
 * Time: 上午9:44
 * To change this template use File | Settings | File Templates.
 */
public class DeepCopy {

    public static  void  main(String[] args) throws CloneNotSupportedException {
        long t1=System.currentTimeMillis();
        Professor p = new Professor("wangwu", 50);
        Student s1 = new Student("zhangsan", 18, p);
        Student s2 = (Student) s1.clone();
        s2.professor.name = "lisi";
        s2.professor.age = 30;
        System.out.println("name=" + s1.professor.name + "," + "age=" + s1.professor.age);// 学生1的教授不改变。
        System.out.println("name=" + s2.professor.name + "," + "age=" + s2.professor.age);// 学生1的教授不改变。
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }
}
