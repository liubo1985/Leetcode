package com.CC150.RemoveElement;

/**
 * Created by bliu on 3/17/16.
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int ptr = 0;
        int newLength = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[ptr] = nums[i];
                ptr++;
                newLength++;
            }

        }
        return newLength;
    }
}
