package com.guozz.practise.leetcode;

public class Huiwenshu20200610 {

    public static void main(String[] args) {
        boolean result = isPalindrome(121);
        System.out.println(result);
    }

    public static boolean isPalindrome(int x) {
        int rev =0;int old = x;
        while (x>0){
            int tem =x%10;
            rev =rev*10+tem;
            x=x/10;
        }
        return old==rev;
    }
}
