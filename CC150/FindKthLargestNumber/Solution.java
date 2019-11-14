package CC150.BinaryTreeMaximumPathSum;

/**
 * Created by bliu on 5/15/16.
 */
/**
 */
public class Solution {

    public int median(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0){
            return 0;
        }
        return findKth(nums, 0, nums.length - 1, (nums.length + 1)/2);
    }

    public int findKth(int[] nums, int start, int end, int kth){
        int i = start;
        int j = end;
        int mid = start + (end - start)/2;
        int pivot = nums[mid];
        int iterator = start;
        while(iterator <= j){
            if (nums[iterator] < pivot){
                swap(nums, iterator, i);
                i++;
                iterator++;
            } else if(nums[iterator] > pivot){
                swap(nums, iterator, j);
                j--;
            } else {
                iterator++;
            }

        }
        if (i - start >= kth){
            return findKth(nums, start, i - 1, kth);
        }else if (j + 1 - start >= kth){
            return nums[j];
        }else {
            return findKth(nums, j + 1, end, kth - (j + 1 - start));
        }
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}