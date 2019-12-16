public class Solution {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0){
            return;
        }
        int left = 0;
        for (int right = 0; right < nums.length; right++){
            if (nums[right] != 0){
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right] = temp;

            }
        }
    }
}