package com.guozz.test.thread.callable;

import java.io.FileOutputStream;

public class TestService {
	
	public static String test(int threadNum) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Thread-----"+threadNum+"-----------");
		stringBuilder.append("\r\n");
		for(int i=0;i<10;i++) {
			stringBuilder.append(i);
			stringBuilder.append("\r\n");
			System.out.println("Thread----->"+Thread.currentThread()+i);
		}
		writToDisk(stringBuilder.toString(),threadNum+"");
		return stringBuilder.toString();
	} 
	
	
	public static void writToDisk(String text,String path) {
         //声明流对象
         FileOutputStream fos = null;
         try{
          //创建流对象
          fos = new FileOutputStream("d:/test/out"+path+".txt",true);
          //转换为byte数组
          byte[] b1 = text.getBytes();
          //依次写入文件
          fos.write(b1);
         } catch (Exception e) {
            e.printStackTrace();
         }finally{
	          try{
	                   fos.close();
	          }catch(Exception e){}
         }
	}

}
