package org.practise.upgrade.interview.algorithm.permutate;

import java.util.Arrays;

public class Main {

	static int sum,temp;  
	static int[] numArr={1,2,3};  
	
	public static void main(String[] args) {  
	    sum=0;  
	    perm(numArr,0,numArr.length-1);  
	    System.out.println(sum);  
	
	}  
	private static void perm(int[] numArr, int start, int end) {  
	    if(start==end){  
	        sum++;  
	        System.out.println(Arrays.toString(numArr));  
	    }else{  
	        for(int i=start;i<=end;i++){  
	            swap(numArr,start,i);  //  交换元素  
	            perm(numArr, start+1, end);   //交换后，再进行全排列算法  
	            swap(numArr,start,i);//将之前交换的数据换回来  
	        }  
	    }  
	}  
	//交换数据  
	private static void swap(int[] numArr, int x, int y) {  
	    temp=numArr[x];  
	    numArr[x]=numArr[y];  
	    numArr[y]=temp;  
	}  
}