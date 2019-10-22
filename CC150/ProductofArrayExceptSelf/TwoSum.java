

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: the product of all the elements of nums except nums[i].
     */
    public int[] productExceptSelf(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0){
            return new int[]{};
        }
        int[] cache = new int[nums.length];
        cache[0] = 1;
        // scan from left to right, cal the product from start to current pointer and store in cache
        for (int i = 1; i < nums.length; i++){
            cache[i] = cache[i - 1] * nums[i - 1];
        }
        //scan from right to left, cal the product from end to current pointer and update the cache
        int product = 1;
        for (int i = nums.length - 2; i >= 0; i--){
            product *= nums[i + 1];
            cache[i] *= product;
        }
        return cache;
    }
}