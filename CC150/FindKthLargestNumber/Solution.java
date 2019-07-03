package CC150.BinaryTreeMaximumPathSum;

/**
 * Created by bliu on 5/15/16.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    public int findKth(int[] nums, int start, int end, int kth){
        int i = start - 1;
        int j = end + 1;
        int mid = start + (end - start)/2;
        int pivot = nums[mid];
        int iterator = start;
        while(iterator < j){
            if (nums[iterator] < pivot){
                i++;
                swap(nums, iterator, i);
                iterator++;
            } else if(nums[iterator] > pivot){
                j--;
                swap(nums, iterator, j);
            } else {
                iterator++;
            }

        }
        if (i - start + 1 >= kth){
            return findKth(nums, start, i, kth);
        }else if (j - start >= kth){
            return nums[j - 1];
        }else {
            return findKth(nums, j, end, kth - (j - start));
        }
    }
}