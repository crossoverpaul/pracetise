package com.guozz.test.current;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 验证SimpleDateFormat在多线程下有问题
 * @author guozhizhong
 * @version 2017-01-13 09:27:13
 */
public class DateUtil {
	
	private DateUtil(){}
	
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(500);
		
		for(int i=0;i<1000;i++){
			executorService.execute(new Runnable() {
				@Override
				public void run() {
				 for (int i = 0; i < 1000000; i++) {
                        try {
                            DATE_FORMAT.parse("2014-01-01 00:00:00");
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
				}
			});
		}
	}
	

}
