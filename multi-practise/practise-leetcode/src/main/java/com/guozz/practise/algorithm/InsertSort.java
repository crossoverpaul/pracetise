package com.guozz.practise.algorithm;

/**
 * 插入排序
 * 空间复杂度 o1
 * 时间复杂度 n2
 */
public class InsertSort {
    public static void main(String[] args) {
        int [] a ={9,3,1,4,6,8,7,5,2};
        printArray(a);
        sort(a);
        printArray(a);

    }

    private static void sort(int[] a) {

        for(int i=1;i<a.length;i++){
            for(int j=i;j>0;j--){
                if(a[j]<a[j-1]){
                    swap(a,j,j-1);
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
        System.out.println();
    }
}
