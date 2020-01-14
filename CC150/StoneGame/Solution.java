public class Solution {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int stoneGame(int[] A) {
        // write your code here
        if (A == null || A.length <= 1){
            return 0;
        }
        int[] sum = new int[A.length + 1];
        sum[0] = 0;
        int[][] dp = new int[A.length][A.length];

        for (int i = 1; i <= A.length; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
            dp[i - 1][i - 1] = 0;
        }

        for (int len = 1; len < A.length; len++) {
            for (int i = 0; i + len < A.length; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k <= j; k++) {
                    int subSum = sum[j + 1] - sum[i];
                    dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + dp[k][j] + subSum);
                }
            }
        }
        return dp[0][A.length - 1];
    }
}