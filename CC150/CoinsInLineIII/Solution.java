public class Solution {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        // 区间型动态规划
        if (values == null || values.length == 0){
            return false;
        }
        int[] sum = new int[values.length + 1];
        sum[0] = 0;
        int[][] dp = new int[values.length][values.length];

        for (int i = 1; i <= values.length; i++) {
            sum[i] = sum[i - 1] + values[i - 1];
        }

        for (int i = 0; i < values.length; i++) {
            dp[i][i] = values[i];
        }
        // 从i到j，当前player可以拿到最大的value
        for (int len = 1; len < values.length; len++) {
            for (int i = 0; i + len < values.length; i++) {
                int j = i + len;
                int intervalSum = sum[j + 1] - sum[i];
                dp[i][j] = Math.max(intervalSum - dp[i + 1][j], intervalSum - dp[i][j - 1]);
            }
        }
        return dp[0][values.length - 1] > sum[values.length] / 2;
    }
}