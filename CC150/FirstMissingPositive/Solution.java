package com.CC150.FirstMissingPositive;

/**
 * Created by bliu on 4/4/16.
 */

public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 1;
        int i = 0;
        int len = nums.length;
        int miss = 0;
        while(i < len){
            if(nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]){
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
            else
                i++;
        }

        for(int j = 0; j < nums.length; j++){
            if(nums[j] != (j + 1)){
                return j + 1;
            }
        }
        //if not found number, e.g. [1,2,3,4], first missed number is 5, return len + 1, easy to leave out
        return len + 1;
    }
}