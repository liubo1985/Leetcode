package com.CC150.NextPermutation;

/**
 * Created by bliu on 3/22/16.
 * 1.Find out the first ascending pair from the end of the list.
 Taking the list [2,3,1] as example, we found the 2<3.
 Assuming the index of first element as i, the latter as j. Each time when j=i+1, reset the j to the end of list and –i.
 Turn to step 4 if the pair not found.
 1.从后往前寻找第一个升序（严格的），比如[2,3,1]，就找到2<3。记升序中前面那一个的下标为i。如果找不到，跳转到4.

 2.if i >= 0, swap the number at indexes i and j.
 After this done, the elements after i is also in descending order.
 2.如果i >= 0, 交换num[i]和num[j]。
 —-这一步完成之后，i后面的数仍然是降序排好序的.

 3.Reverse the elements after i. And return.
 3.将i之后的部分逆转，程序返回。

 4.If no ascending pair is found, that means the given list is well sorted in the descending order. In this case, just
 reverse the whole list as required in this problem.
 4.如果没有找到升序，说明整个序列都是降序排序的，就意味着这个序列是排列中的最后一个序列了。直接逆转所有元素，成为升序序列返回（第一个排列）。
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
