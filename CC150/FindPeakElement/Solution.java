package CC150.FindPeakElement;

/**
 * Created by bliu on 5/15/16.
 */

public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[mid - 1]){
                start = mid;
            }
            else if(nums[mid] > nums[mid + 1]){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(nums[start] > nums[end]){
            return start;
        }
        else{
            return end;
        }
    }
}