public class Solution {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int size = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[size] != nums[i]){
                size++;
                nums[size] = nums[i];
            }
        }
        return size + 1;
    }
}