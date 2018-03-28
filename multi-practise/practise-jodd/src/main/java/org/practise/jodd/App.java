package org.practise.jodd;

import java.util.HashMap;

import jodd.bean.BeanUtilBean;
import jodd.util.PrettyStringBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println(PrettyStringBuilder.str(
    			
    	new HashMap<String,String>() {
    		{
    			put("a", "1");
    			put("b", "2");
    			put("c", "3");
    		}
    	}
    	
    			));
    }
}
