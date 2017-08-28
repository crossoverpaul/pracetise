package org.practis.structure.find;

import java.util.Scanner;

/**
 * 顺序查找算法
 * @author 郭智忠
 *
 */
public class Sequencesearch {
	public static void main(String[] arg) {  
	    int[] a={4,6,2,8,1,9,0,3};
	    Scanner input=new Scanner(System.in);
	    System.out.println("请输入你要查找的数：");
	    //存放控制台输入的语句
	    int num=input.nextInt();
	    //调用searc()方法，将返回值保存在result中
	    int result=search(a, num);
	    if(result==-1){
	         System.out.println("你输入的数不存在与数组中。");
	    }
	    else
	         System.out.println("你输入的数字存在，在数组中的位置是第："+(result+1)+"个");
	}
	public static int search(int[] a, int num) {        
	    for(int i = 0; i < a.length; i++) {
	        if(a[i] == num){//如果数据存在
	            return i;//返回数据所在的下标，也就是位置
	        }
	    } 
	    return -1;//不存在的话返回-1
	}
}
