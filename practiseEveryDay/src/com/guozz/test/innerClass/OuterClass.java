package com.guozz.test.innerClass;

/**
 * @author guozhizhong
 * @version 2016-11-28 15:54:14
 */
public class OuterClass {
	
	private String name;
	
	private int age;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public class InnerClass{

		public InnerClass() {
			name="paul";
			age=23;
		}
		
		public void display(){
			System.out.println("name = " +getName()+",age =  "+getAge());
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OuterClass outerClass = new OuterClass();
		OuterClass.InnerClass innerClass = outerClass.new InnerClass();
		innerClass.display();
	}

}
