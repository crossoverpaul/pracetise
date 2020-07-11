package com.guozz.practise.algorithm;

/**
 * 选择排序
 * 空间复杂度 1
 * 实际那复杂度 n2
 */
public class SelectionSort {

    public static void main(String[] args) {
        int  [] a ={5,3,6,8,1,7,9,4,2};
        printArray(a);
        for(int i=0;i<a.length;i++){
            int minPos =i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[minPos]){
                    minPos=j;
                }
            }
            System.out.println("minPos-----"+minPos);
            int temp =a[i];
            a[i]=a[minPos];
            a[minPos]=temp;
        }


        printArray(a);

    }

    private static void printArray(int[] a) {
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
