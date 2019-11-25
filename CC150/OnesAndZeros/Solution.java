public class Solution {
    /**
     * @param strs: an array with strings include only 0 and 1
     * @param m: An integer
     * @param n: An integer
     * @return: find the maximum number of strings
     */
    public int findMaxForm(String[] strs, int m, int n) {
        // write your code here
        if (m == 0 && n == 0){
            return 0;
        }
        if (strs == null || strs.length == 0){
            return 0;
        }
        int[] cnt0 = new int[strs.length];
        int[] cnt1 = new int[strs.length];

        for (int i = 0; i < strs.length; i++){
            for (int j = 0; j < strs[i].length(); j++){
                if (strs[i].charAt(j) == '0'){
                    cnt0[i]++;
                } else {
                    cnt1[i]++;
                }
            }
        }

        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 0; i <= m; i++){
            for (int j = 0; j <= n; j++){
                dp[0][i][j] = 0;
            }
        }

        for (int i = 1; i <= strs.length; i++){
            for (int j = 0; j <= m; j++){
                for (int k = 0; k <= n; k++){
                    // case 1: strs[i - 1] is not selected
                    dp[i][j][k] = dp[i - 1][j][k];
                    // case 2 : strs[i - 1] is selected
                    if (cnt0[i - 1] <= j && cnt1[i - 1] <= k){
                        // select larger value
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - cnt0[i - 1]][k - cnt1[i - 1]] + 1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }
}