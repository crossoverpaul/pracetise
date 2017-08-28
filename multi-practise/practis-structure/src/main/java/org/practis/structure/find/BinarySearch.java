package org.practis.structure.find;

import java.util.Scanner;

public class BinarySearch {

	 public static void main(String[] args) {
	        int[] arr={5,3,6,1,9,8,2,4,7};
	        //先打印输出原始数组数据
	        System.out.println("原始数组数据如下：");
	        for (int n : arr) {
	            System.out.print(n+" ");
	        }
	        System.out.println();
	        //首先对数组进行排序，这里用冒泡排序
	        for(int i=0;i<arr.length-1;i++){
	            for(int j=0;j<arr.length-1-i;j++){
	                if(arr[j]>arr[j+1]){
	                    int temp=arr[j];
	                    arr[j]=arr[j+1];
	                    arr[j+1]=temp;
	                }
	            }
	        }
	        //遍历输出排序好的数组
	        System.out.println("经过冒泡排序后的数组：");
	        for(int n:arr){
	            System.out.print(n+" ");
	        }
	        System.out.println();//换行
	        Scanner input=new Scanner(System.in);
	        System.out.println("请输入你要查找的数：");
	        int num=input.nextInt();
	        int result=binarySearch(arr, num);
	        if(result==-1){
	            System.out.println("你要查找的数不存在……");
	        }
	        else{
	            System.out.println("你要查找的数存在，在数组中的位置是："+result);
	        }
	    }
	    //二分查找算法
	    public static int binarySearch(int[] arr,int num){
	    
	        int low=0;
	        int upper=arr.length-1;
	        while(low<=upper){
	            int mid=(upper+low)/2;
	            if(arr[mid]<num){
	                low=mid+1;
	            }
	            else if(arr[mid]>num){
	                upper=mid-1;
	            }
	            else
	                return mid;
	        }
	        return -1;
	    }
}
