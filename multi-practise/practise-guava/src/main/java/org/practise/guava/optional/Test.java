package org.practise.guava.optional;

import java.util.List;

import com.google.common.base.*;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class Test {
//	public void should_get_total_age_for_all_employees() throws Exception {
//	    final List<Employee> list = Lists.newArrayList(new Employee("em1", 30), new Employee("em2", 40), null, new Employee("em4", 18));
//	    int sum = 0;
//	    for (Employee employee : list) {
//	        if (employee != null) {
//	            sum += employee.getAge();
//	        }
//	    }
//	    System.out.println(sum);
//	}
	private class Employee {
	    private final String name;
	    private final int age;
	    public Employee(String name, int age) {
	        this.name = name;
	        this.age = age;
	    }
	    public String getName() {
	        return name;
	    }
	    public int getAge() {
	        return age;
	    }
	}
	
	
	
	public void should_get_total_age_for_all_employees() throws Exception {
	    final List<Employee> list = Lists.newArrayList(new Employee("em1", 30),
	        new Employee("em2", 40),
	         null,
	         new Employee("em4", 18));
	    int sum = 0;
	    for (Employee employee : list) {
	        sum += Optional.fromNullable(employee).or(new Employee("dummy", 0)).getAge();
	    }
	    System.out.println(sum);
	}
	
	public static void main(String[] args) throws Exception {
		Test test = new Test();
		test.should_get_total_age_for_all_employees();
		
		int age = 0;
	    System.out.println("user age:"+age);
	    
	    long money;
        money=10L;
        System.out.println("user money"+money);
        
        String name = null;
        System.out.println("user name:"+name);
        System.out.println("------------------华丽丽的分割线-------------------");
        if(null instanceof Object) {
        	System.out.println("null 是对象");
        }else {
        	System.out.println("null 不是对象");
		}
        
        System.out.println("------------------华丽丽的分割线testOptional-------------------");
        testOptional();
        System.out.println("------------------华丽丽的分割线testOptional2-------------------");
        testOptional2();
	}
	
	
	 public static void testOptional() throws Exception { 

//		 List<String> list=ImmutableList.<String>builder()
//				 						.add("a")
//				 						.add("b")
//				 						.add("c")
//				 						.build();
//		 Optional<List<String>> possible=Optional.of(list);
		 
		 List<String> list=Lists.newArrayList();
		 list=null;
		 Optional<List<String>> possible=Optional.fromNullable(list);
		 
		 if(possible.isPresent()) {
			 System.out.println("possible isPresent:"+possible.isPresent());
             System.out.println("possible value:"+possible.get());
		 }else {
			 System.out.println("获得的值不是期望的值");
		 }
	    } 
	 
	    public static void testOptional2() throws Exception { 
	        Optional<Integer> possible=Optional.of(6);
	        Optional<Integer> absentOpt=Optional.absent();
	        Optional<Integer> NullableOpt=Optional.fromNullable(null);
	        Optional<Integer> NoNullableOpt=Optional.fromNullable(10);
	        if(possible.isPresent()){
	            System.out.println("possible isPresent:"+possible.isPresent());
	            System.out.println("possible value:"+possible.get());
	        }
	        if(absentOpt.isPresent()){
	            System.out.println("absentOpt isPresent:"+absentOpt.isPresent()); ;
	        }
	        if(NullableOpt.isPresent()){
	            System.out.println("fromNullableOpt isPresent:"+NullableOpt.isPresent()); ;
	        }
	        if(NoNullableOpt.isPresent()){
	            System.out.println("NoNullableOpt isPresent:"+NoNullableOpt.isPresent()); ;
	        }
	    } 
    
}
