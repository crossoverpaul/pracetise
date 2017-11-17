package com.guozz.test.lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {

	@org.junit.Test
	public void test1 () {
		new Thread(new Runnable() {
			@Override
			public void run() {
				double a=1.6;
				double b=1.6;
				System.out.println(a+b);
			}
		}).start();
	}
	
	/**
	 * 匿名函数
	 */
	@org.junit.Test
	public void test2 () {
		new Thread(()->{
			double a=1.6;
			double b=1.6;
			System.out.println(a+b);
		}) .start();
	}
	
	@org.junit.Test
	public void test3 () {
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		for (String feature : features) {
		    System.out.println(feature);
		}
	}
	
	/**
	 * foreach+迭代
	 */
	@org.junit.Test
	public void test4 () {
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		features.forEach(n->{
			if(!n.contains("Lambdas")) {
				System.out.println(n);
			}
		});
	}
	
	
	/**
	 * Predicate
	 */
	@org.junit.Test
	public void test5 () {
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		System.out.println("Languages which starts with J :");
	    filter(languages, (str)->true);
	}
	
	public static void filter(List<String> names, Predicate condition) {
	    for(String name: names)  {
	        if(condition.test(name)) {
	            System.out.println(name + " ");
	        }
	    }
	}

	/**
	 * 过滤字符串
	 */
	@org.junit.Test
	public void test6 () {
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		List<String> filtered=languages.stream().filter(x->x.length()>3).collect(Collectors.toList());
		filtered.forEach(str->{
			System.out.println(str);
		});
	}
	
	/**
	 * 应用函数
	 */
	@org.junit.Test
	public void test7 () {
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		String result= languages.stream().map(str->str.toUpperCase()).collect(Collectors.joining(","));
		System.out.println(result);
	}
	

	/**
	 * 创建子列表
	 */
	@org.junit.Test
	public void test8 () {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,1,9);
		List<Integer> distinct =numbers.stream().map(i->i*i).distinct().collect(Collectors.toList());
		distinct.forEach(num->{
			System.out.println(num);
		});
	}
	
	/**
	 * 创建最小值最大值
	 */
	@org.junit.Test
	public void test9 () {
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics intSummaryStatistics= primes.stream().mapToInt((x)->x).summaryStatistics();
		System.out.println("Highest prime number in List : " + intSummaryStatistics.getMax());
		System.out.println("Lowest prime number in List : " + intSummaryStatistics.getMin());
		System.out.println("Sum of all prime numbers : " + intSummaryStatistics.getSum());
		System.out.println("Average of all prime numbers : " + intSummaryStatistics.getAverage());
		
	}
}
