package com.guozz.practise.leetcode;

/**
 * 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Algorithm05 {


    /**
     * 方法一、数组合并（归并）
     * 在两个有序的数组中要找到某个数，估计大家第一想到的就是归并的方法。这也是归并排序的基本思想。开辟一个新的数组help，长度为两个数组的长度和。使用两个指针分别指向两个数组的开头，比较两个指针所指的元素，将比较小的元素放入到新的数组中。之后继续上述的操作，直到将所有的数都放入到help中。举一个简单的例子：将两个有序数组[1,3,5,6,7]与[2,4,8]合并为一个数组：
     *
     *
     * 本题是要求找中位数，中位数就是两个数组长度和的一半的位置。但是这里要注意长度奇数偶数的情况：
     *
     * 如果总长度为奇数的话，那么合并后中间的那个数就是结果
     * 如果总长度为偶数的话，那合并后中间两个数的平均数就是结果
     * 这里由于只需要找中位数，所以数组归并到中位数的位置就可以了，可以声明一个变量k作为跳出条件。
     *
     * 归并的方法简单易懂，时间复杂度与空间复杂度均为线性复杂度O(m+n)。并不符合题目要求。但是这种方法也是接下来方法的关键。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length+nums2.length;
        double result =0;
        //偶数
        if(length % 2 ==0){
            result=getNum(nums1,nums2,length/2-1)/2+getNum(nums1,nums2,length/2)/2;
        }else{
            //基数
            result=getNum(nums1,nums2,length/2);
        }
        return result;
    }

    private double getNum(int[] nums1, int[] nums2, int k) {
        int [] result = new int[nums1.length+nums2.length];
        int i=0,j=0;
        int cur=0;
        while(i<nums1.length&&j<nums2.length&&cur<k){
            if(nums1[i] < nums2[j]){
                result[cur++] = nums1[i++];
            }else{
                result[cur++] = nums2[j++];
            }
        }
        while(i < nums1.length && cur <=k){
            result[cur++] = nums1[i++];
        }
        while(j < nums2.length && cur <=k){
            result[cur++] = nums2[j++];
        }
        return result[cur-1];

    }

    public static void main(String[] args) {
    }
}
