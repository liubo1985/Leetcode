package com.CC150.RemoveDuplicatesfromSortedArray;

/**
 * Created by bliu on 3/17/16.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        int size = 1;
        int nonDup = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != nonDup){
                nums[size] = nums[i];
                size++;
                nonDup = nums[i];

            }
        }
        return size;
    }
}
