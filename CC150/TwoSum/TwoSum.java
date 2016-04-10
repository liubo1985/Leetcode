package com.CC150.TwoSum;

import java.util.HashMap;

/**
 * Created by bliu on 3/5/16.
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2)
            return null;

        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int[] results = new int[2];

        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) != null){
                results[0] = (int)map.get((int)nums[i]);
                results[1] = i;
                return results;
            }
            else
                map.put(target - nums[i], i);
        }

        return null;

    }

    public static void main(String[] args){
        int[] nums = new int[]{1, 3, 7, 3, 2};
        int[] results = twoSum(nums, 6);
        System.out.println("The indices is: [" + results[0] + ", " + results[1] + "]");
    }
}