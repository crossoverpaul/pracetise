package com.guozz.test.upgradejava.chapter6.shallowcopy;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-6-16
 * Time: 上午9:44
 * To change this template use File | Settings | File Templates.
 */
public class ShallowCopy {

    public static  void  main(String[] args) throws CloneNotSupportedException {
        Professor0 professor0 =new Professor0("王五",50);
        Student0 student1 = new Student0("张三",20,professor0);
        Student0 student2 = (Student0) student1.clone();
        student2.age=30;
        student2.name="李四";
        student2.professor0.name="王六";
        student2.professor0.age=55;
        // 学生1的教授
        System.out.println("学生s1的姓名:" + student1.name +"\n学生s1的年龄:" + student1.age+ "\n学生s1教授的姓名：" + student1.professor0.name + "," + "\n学生s1教授的年纪:" + student1.professor0.age);
    }
}
