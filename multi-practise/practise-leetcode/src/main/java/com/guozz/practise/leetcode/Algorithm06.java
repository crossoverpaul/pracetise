package com.guozz.practise.leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 *
 * 利用动态规划算法
 */
public class Algorithm06 {

    public static void main(String[] args) {
        String str="bacacab";
        System.out.println(longestPalindrome2(str));


        //最长不下降子序列
//        int [] a =  {4,6,5,7,3};
//        System.out.println(MaxChildArrayOrder(a));

    }

    public static  String longestPalindrome1(String s) {

        String result = "";

        boolean table[][] = new boolean[s.length()][s.length()];

        // length === 1;
        for (int i = 0; i < table.length; i++) {
            table[i][i] = true;
            result = s.substring(i, i + 1);
        }

        // length === 2;
        for (int i = 0; i < table.length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
                result = s.substring(i, i + 2);
            } else {
                table[i][i + 1] = false;
            }
        }

        // length > 2;
        for (int len = 3; len <= table.length; len++) {
            for (int i = 0; i + len <= table.length; i++) {
                char front = s.charAt(i);
                char end = s.charAt(i + len - 1);
                if (front == end) {
                    table[i][i + len - 1] = table[i + 1][i + len - 2];
                } else {
                    table[i][i + len - 1] = false;
                }
                if(table[i][i + len - 1]){
                    result = s.substring(i, i + len);
                }
            }
        }

        return result;
    }


    /**
     * 求最长回文子串 -动态规划算法
     * @param str
     * @return
     */
    public static String longestPalindrome2(String str) {

        int len = str.length();
        if(len<2){
            return str;
        }

        int maxLen=1;
        int begin =0;

        // 1. 状态定义
        // dp[i][j] 表示s[i...j] 是否是回文串

        boolean [][] dp= new boolean[len][len];

        // 2. 初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] chars= str.toCharArray();
        //3.状态转移
        // 注意：先填左下角
        // 填表规则：先一列一列的填写，再一行一行的填，保证左下方的单元格先进行计算
        for(int j=1;j<len;j++){
            for(int i=0;i<j;i++){
                //头尾字符不相等不是回文串
                if(chars[i]!=chars[j]){
                    dp[i][j]=false;
                }else{
                    // 相等的情况下
                    // 考虑头尾去掉以后没有字符剩余，或者剩下一个字符的时候，肯定是回文串
                    if(j-i<3){
                        dp[i][j] = true;
                    }else{
                        // 状态转移
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要dp[i][j] == true 成立，表示s[i...j] 是否是回文串
                // 此时更新记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        // 4. 返回值
        return str.substring(begin,begin + maxLen);
    }



    /**
     *数组最大不连续递增子序列
     * @param a
     * @return
     */
    public static int MaxChildArrayOrder(int a[]) {
        int n = a.length;
        //temp[i]代表0...i上最长递增子序列
        int temp[] = new int[n];
        for (int i = 0; i < n; i++) {
            //初始值都为1
            temp[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && temp[j] + 1 > temp[i]) {
                    //如果有a[i]比它前面所有的数都大，则temp[i]为它前面的比它小的数的那一个temp+1取得的最大值
                    temp[i] = temp[j] + 1;
                }
            }
        }
        printArray(temp);
        int max = temp[0];
        //从temp数组里取出最大的值
        for (int i = 1; i < n; i++) {
            if (temp[i] > max) {
                max = temp[i];
            }
        }
        return max;
    }

    private static void printArray(int[] temp) {
        System.out.println("--------------------------");
        for(int i=0;i<temp.length;i++){
            if(i==temp.length-1){
                System.out.println(temp[i]+"|");
            }else{
                System.out.print(temp[i]+"|");
            }

        }
        System.out.println("--------------------------");

    }
}
