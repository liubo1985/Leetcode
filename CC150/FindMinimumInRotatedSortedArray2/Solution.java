package CC150.FindMinimumInRotatedSortedArray2;

/**
 * Created by bliu on 5/11/16.
 */


//This is a follow up for "Find minimum in ratated sorted array, if duplicates appear in the array, no way to do
// binary search, only use O(n) method"
public class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
            }
        }
        return min;
    }
}