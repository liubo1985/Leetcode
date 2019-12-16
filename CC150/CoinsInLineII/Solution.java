public class Solution {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length <= 2) {
            return true;
        }
        // if i conis left, the sum of those coins' values
        int[] sum = new int[values.length + 1];
        // if i coins left, the max value that the current player can get
        int[] dp  = new int[values.length + 1];
        sum[0] = 0;
        sum[1] = values[values.length - 1];
        sum[2] = sum[1] + values[values.length - 2];

        dp[0] = 0;
        dp[1] = values[values.length - 1];
        dp[2] = values[values.length - 1] + values[values.length - 1];

        for (int i = 3; i <= values.length; i++){
            sum[i] = sum[i - 1] + values[values.length - i];
            dp[i] = Math.max(sum[i] - dp[i - 1], sum[i] - dp[i - 2]);
        }

        return dp[values.length] > sum[values.length] / 2;
    }
}