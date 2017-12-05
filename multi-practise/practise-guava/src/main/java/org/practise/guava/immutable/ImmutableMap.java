package org.practise.guava.immutable;

import java.util.Map;
import java.util.Map.Entry;


public class ImmutableMap {

	public static void main(String[] args) {
		Map<Object, Object> map =com.google.common.collect.ImmutableMap.builder()
								.put(1,"a")
								.put(2,"b")
								.put(3,"c")
								.put(4,"d")
								.build();
		
		for(Entry<Object, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
	}
}
