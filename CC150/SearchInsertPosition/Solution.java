package com.CC150.SearchInsertPosition;

/**
 * Created by bliu on 3/29/16.
 */

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while(start + 1 < end){
            mid = (start + end)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if(nums[start] >= target){
            return start;
        }else if(nums[end] >= target){
            return end;
        }else{
            return end + 1;
        }
    }
}