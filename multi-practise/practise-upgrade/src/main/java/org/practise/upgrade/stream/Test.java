package org.practise.upgrade.stream;

import java.util.*;
import java.util.stream.*;

public class Test {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	    Stream<Integer> stream = numbers.stream();
	    stream.filter((x) -> {
	        return x % 2 == 0;
	    }).map((x) -> {
	        return x * x;
	    }).forEach(System.out::println);
	}
}
