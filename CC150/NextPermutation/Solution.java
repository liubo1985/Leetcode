package com.CC150.NextPermutation;

/**
 * Created by bliu on 3/22/16.
 */
public class Solution {

        public void nextPermutation(int[] nums) {
            if(nums == null)
                return;
            int i;
            for(i = nums.length - 1; i > 0; i--){
                if(nums[i - 1] < nums[i]){
                    int j;
                    for(j = nums.length - 1; j > i - 1; j--){
                        if(nums[j] > nums[i - 1]){
                            break;
                        }
                    }
                    swap(nums, i - 1, j);
                    reverse(nums, i, nums.length - 1);
                    return;
                }
            }
            //if(i == 0)
            reverse(nums, 0, nums.length - 1);
        }

        private void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private void reverse(int[] nums, int start, int end){
            while(start < end){
                swap(nums, start, end);
                start++;
                end--;
            }
        }


    public static void main(String[] args){
        int[] nums = new int[]{1, 2};
        Solution sol = new Solution();
        sol.nextPermutation(nums);
        System.out.println("The next permutation is: ");
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
