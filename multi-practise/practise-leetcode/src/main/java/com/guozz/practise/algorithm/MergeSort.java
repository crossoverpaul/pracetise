package com.guozz.practise.algorithm;

/**
 * 归并排序
 * 空间复杂度 o1
 * 时间复杂度 n的1.3次方  最好 n  最坏 n的平方
 */
public class MergeSort {
    public static void main(String[] args) {
        int [] a ={9,3,1,4,6,8,7,5,2};
        printArray(a);
        sort(a);
        printArray(a);

    }

    private static void sort(int[] a) {
        for(int gap =a.length/2;gap>0;gap/=2){
            for(int i=gap;i<a.length;i++){
                for(int j=i;j>gap-1;j-=gap){
                    if(a[j]<a[j-gap]){
                        swap(a,j,j-gap);
                    }
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
