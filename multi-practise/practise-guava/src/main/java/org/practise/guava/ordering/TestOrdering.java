package org.practise.guava.ordering;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

public class TestOrdering {

	public static void main(String[] args) {
		List<String> list = Lists.newArrayList();
        list.add("peida");
        list.add("jerry");
        list.add("harry");
        list.add("eva");
        list.add("jhon");
        list.add("neron");
        
        System.out.println("list"+list);
        
        Ordering<String> naturalOrdering=Ordering.natural();
        Ordering<Object> usingToStringOrdering =Ordering.usingToString();
        Ordering<Object> arbitraryOrdering =Ordering.arbitrary();
        
        System.out.println("naturalOrdering:"+naturalOrdering.sortedCopy(list));
        System.out.println("usingToStringOrdering:"+usingToStringOrdering.sortedCopy(list));
        System.out.println("arbitraryOrdering:"+arbitraryOrdering.sortedCopy(list));
        
        Ordering<String> ordering = Ordering.natural().nullsFirst().onResultOf(new Function<String, String>() {
        	  public String apply(String str) {
        	    return str;
        	  }
        	});

        System.out.println("ordering:"+ordering.sortedCopy(list));
        
	}
}
