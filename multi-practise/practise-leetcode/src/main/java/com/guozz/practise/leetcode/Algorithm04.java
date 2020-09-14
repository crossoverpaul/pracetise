package com.guozz.practise.leetcode;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 解题思路 这道题主要用到思路是：滑动窗口
 */
public class Algorithm04 {

    public static int lengthOfLongestSubstring(String s) {
       if(s==null|| s.length()==0){
           return 0;
       }
       char[] sArr = s.toCharArray();
       int [] hash = new int[256];
       int l = 0, result = 1;
       for(int r=0;r<sArr.length;r++){
           //hash[sArr[r]]++;
           hash[sArr[r]]= hash[sArr[r]]+1;
           while(hash[sArr[r]] != 1) {
               hash[sArr[l]]--;
               l++;

           }
           result = Math.max(result, r - l + 1);
       }

        return result;

    }

    public static void main(String[] args) {
        String str="abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
