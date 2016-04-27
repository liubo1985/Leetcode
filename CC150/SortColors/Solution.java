package CC150.SortColors;

/**
 * Created by bliu on 4/22/16.
 * 首尾指针，中间用第三个指针遍历数组，0就扔到左边，2就扔到右边，剩下的就是1在中间
 */

public class Solution {
    public void sortColors(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while(i <= right){
            if(nums[i] == 0){
                swap(nums, i, left);
                left++;
                i++;
            }
            else if(nums[i] == 1){
                i++;
            }
            else {
                swap(nums, i, right);
                right--;
            }
        }
    }

    public void swap(int[] nums, int n, int m){
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }
}