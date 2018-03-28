package org.practise.guava.optional;

import java.util.Set;

import com.google.common.base.Optional;

public class OptionalTest2 {

	public static  void main(String[] args) {
        Optional<Long> value = method();
        if(value.isPresent()==true){
            System.out.println("获得返回值: " + value.get());     
        }else{
            System.out.println("获得返回值: " + value.or(-12L));    
        }
        
        System.out.println("获得返回值 orNull: " + value.orNull());
        System.out.println("-----------分割线--------------");
        
        Optional<Long> valueNoNull = methodNoNull();
        if(valueNoNull.isPresent()==true){
            Set<Long> set=valueNoNull.asSet();
            System.out.println("获得返回值 set 的 size : " + set.size());    
            System.out.println("获得返回值: " + valueNoNull.get());     
        }else{
            System.out.println("获得返回值: " + valueNoNull.or(-12L));    
        }
        
        System.out.println("获得返回值 orNull: " + valueNoNull.orNull());
    }

    private static Optional<Long> method() {
        return Optional.fromNullable(null);
    }
    private static Optional<Long> methodNoNull() {
        return Optional.fromNullable(15L);
    }
    
}
