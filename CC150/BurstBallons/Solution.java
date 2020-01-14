public class Solution {
    /**
     * @param nums: A list of integer
     * @return: An integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] newNums = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }
        newNums[0] = 1;
        newNums[newNums.length - 1] = 1;

        int[][] dp = new int[nums.length + 2][nums.length + 2];
        //initilization
        for (int i = 1; i < newNums.length - 1; i++){
            dp[i][i] = newNums[i - 1] * newNums[i] * newNums[i + 1];
        }
        //
        for (int len = 1; len < newNums.length - 1; len++) {
            for (int i = 1; i + len < newNums.length; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + newNums[i - 1] * newNums[k] * newNums[j + 1] + dp[k + 1][j]);

                }
            }
        }
        return dp[1][newNums.length - 2];
    }
}