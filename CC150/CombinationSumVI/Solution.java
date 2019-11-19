public class Solution {
    /**
     * @param nums: an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer
     */
    public int backPackVI(int[] nums, int target) {
        //write your code here
        if (nums == null){
            return 0;
        }


        int[] dp = new int[target + 1];

        // initicialization
        dp[0] = 1;

        for (int i = 1; i <= target; i++){
            for (int j = 1; j <= nums.length; j++){
                if (i < nums[j - 1])
                    continue;
                dp[i] += dp[i - nums[j - 1]];

            }
        }
        return dp[target];
    }
}