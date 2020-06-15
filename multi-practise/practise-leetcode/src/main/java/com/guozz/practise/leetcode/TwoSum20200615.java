package com.guozz.practise.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum20200615 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer ,Integer> map = new HashMap<Integer ,Integer>();
            for(int i=0;i<nums.length;i++){
                map.put(nums[i],i);
            }
            for(int i=0;i<nums.length;i++){
                int afterSub = target - nums[i];
                if(map.containsKey(afterSub)&&map.get(afterSub)!=i){
                    return new int[] { i, map.get(afterSub) };
                }
            }
            throw new IllegalArgumentException();
        }
    }
}
