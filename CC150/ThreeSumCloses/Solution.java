package com.CC150.ThreeSumCloses;

import java.util.Arrays;

/**
 * Created by bliu on 3/14/16.
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3 && nums == null){
            return Integer.MAX_VALUE;
        }
        Arrays.sort(nums);
        //List<List<Integer>> all_threeSum = new ArrayList<List<Integer>>();
        int closes = Integer.MAX_VALUE/2; //if target value is -1, closes will overflow, 2147483647 - (-1) ---overflow
        for(int i = 0; i < nums.length - 2; i++){

            int start = i + 1;
            int end = nums.length - 1;

            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum == target){

                    return sum;

                }
                else if(sum > target){
                    end--;
                }
                else{
                    start++;
                }
                closes = Math.abs(sum - target) > Math.abs(closes - target)? closes : sum;
            }
        }
        return closes;
    }

}