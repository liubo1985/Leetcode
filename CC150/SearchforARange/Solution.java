package com.CC150.SearchforARange;

/**
 * Created by bliu on 3/29/16.
 */

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];
        int start = 0;
        int end = nums.length - 1;
        while(start + 1< end){
            int middle = (start + end)/2;
            if(nums[middle] == target){
                end = middle;
            }
            else if(nums[middle] > target){
                end = middle;
            }
            else {
                start = middle;
            }
        }

        if (nums[start] == target) {
            range[0] = start;
        } else if (nums[end] == target) {
            range[0] = end;
        } else {
            range[0] = range[1] = -1;
            return range;
        }

        int j;
        for(j = range[0]; j < nums.length; j++){
            if(nums[j] != target)
                break;
        }

        range[1] = j - 1;

        return range;
    }
}