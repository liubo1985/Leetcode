public class Solution {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int stoneGame2(int[] A) {
        // write your code here
        // 化环为链， double一下长度为n的数组，在这2n的数组上，任何一段[i ， i + n - 1]的
        // 子段都是环的一种断开方式
        if (A == null || A.length <= 1){
            return 0;
        }
        int[] sum = new int[2 * A.length + 1];
        sum[0] = 0;
        int[][] dp = new int[2 * A.length][2 * A.length];

        for (int i = 1; i <= 2 * A.length; i++) {
            sum[i] = sum[i - 1] + A[(i - 1) % A.length];
            dp[i - 1][i - 1] = 0;
        }

        for (int len = 1; len < 2 * A.length; len++) {
            for (int i = 0; i + len < 2 * A.length; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k <= j; k++) {
                    int subSum = sum[j + 1] - sum[i];
                    dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + dp[k][j] + subSum);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++)
            if (dp[i][i + A.length - 1] < ans)
                ans = dp[i][i + A.length - 1];
        return ans;
    }
}