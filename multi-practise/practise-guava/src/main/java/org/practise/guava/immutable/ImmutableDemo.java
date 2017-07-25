package org.practise.guava.immutable;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

public class ImmutableDemo {

	public static void main(String[] args) {
		//1.builder创建
		Set<String> immutableNameColors=ImmutableSet.<String>builder()
										.add("red","green","blue")
										.build();
		for(String color : immutableNameColors) {
			System.out.println(color);
		}
		//2.静态方法创建
		ImmutableSet.of("red","green","blue");
		//2.copy方法创建
		ImmutableSet.copyOf(new String[]{"red","green","black","white","grey"});
		
	}
}
