package org.practise.guava.string;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.*;

public class Test {

	public static void main(String[] args) {
		//1. 使用com.google.common.base.Strings类的isNullOrEmpty(input)方法判断字符串是否为空
		String input ="";
		boolean result = Strings.isNullOrEmpty(input);
		System.out.println(result);
		
		
		//2. 获得两个字符串相同的前缀或者后缀
        String a = "com.jd.coo.Hello";
        String b = "com.jd.coo.Hi";
        String ourCommonPrefix = Strings.commonPrefix(a,b);
        System.out.println("a,b common prefix is " + ourCommonPrefix);

        String c = "com.google.Hello";
        String d = "com.jd.Hello";
        String ourSuffix = Strings.commonSuffix(c,d);
        System.out.println("c,d common suffix is " + ourSuffix);
        
        //3. Strings的padStart和padEnd方法来补全字符串
        int minLength = 4;
        String padEndResult = Strings.padEnd("123", minLength, '0');
        System.out.println("padEndResult is " + padEndResult);

        String padStartResult = Strings.padStart("1", 2, '0');
        System.out.println("padStartResult is " + padStartResult);
        
        //4. 使用Splitter类来拆分字符串
        Iterable<String> splitResults = Splitter.onPattern("[,，]{1,}")
                .trimResults()
                .omitEmptyStrings()
                .split("hello,word,,世界，水平");

        for (String item : splitResults) {
            System.out.println(item);
        }
        
        
        //5. 有拆分字符串必然就有合并字符串，guava为我们提供了Joiner类来做字符串的合并
        String joinResult = Joiner.on(" ").join(new String[]{"hello","world"});
        System.out.println(joinResult);
		
        
        
        Map<String,String> map = new HashMap<String,String>();
        map.put("a", "b");
        map.put("c","d");
        String mapJoinResult = Joiner.on(",").withKeyValueSeparator("=").join(map);
        System.out.println(mapJoinResult);
	}
}
