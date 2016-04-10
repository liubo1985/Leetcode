package com.CC150.SearchinRotatedSortedArray;

/**
 * Created by bliu on 3/24/16.
 */
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int mid;
        //pay attation to the boudary condition
        while(right >= left){
            mid = (left + right)/2;
            if(target == nums[mid]){
                return mid;
            }
            //left boundary
            if(nums[mid] >= nums[left]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else{
                //right boundary
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}