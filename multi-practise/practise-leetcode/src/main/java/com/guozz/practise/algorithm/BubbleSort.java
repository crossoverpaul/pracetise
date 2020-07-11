package com.guozz.practise.algorithm;

/**
 * 第二节冒泡排序
 * 空间复杂度 1
 * 时间复杂度 n2  最好 n  稳定
 */
public class BubbleSort {

    public static void main(String[] args) {
        int [] a = {9,3,1,4,6,8,7,5,2};
        sort(a);
        printArray(a);
    }

    private static void sort(int[] a) {
        for(int j=a.length;j>0;j--){
            for(int i=0;i<a.length-1;i++){
                if(a[i]>a[i+1]){
                    swap(a,i,i+1);
                }
            }
        }


    }

    private static void swap(int[] a, int i, int j) {
        int temp =a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    private static void printArray(int[] a) {
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
