package CC150.FindMinimuminRotatedSortedArray;

/**
 * Created by bliu on 5/11/16.
 */

public class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0){
            return Integer.MIN_VALUE;
        }

        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] <= nums[end]){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(nums[start] < nums[end]){
            return nums[start];
        }
        else{
            return nums[end];
        }

    }
}