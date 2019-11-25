public class Solution {
    /**
     * @param A: An integer array
     * @param k: A positive integer (k <= length(A))
     * @param target: An integer
     * @return: An integer
     */
    public int kSum_no_optimization(int[] A, int k, int target) {
        // write your code here
        if (A == null || A.length == 0){
            return 0;
        }
        int[][][] dp = new int[A.length + 1][k + 1][target + 1];
        // initializaiton
        dp[0][0][0] = 1;
        //
        for (int i = 1; i <= A.length; i++){
            for (int j = 0; j <= k; j++){
                for (int s = 0; s <= target; s++){
                    // case 1 : not select A[i - 1]
                    dp[i][j][s] = dp[i - 1][j][s];
                    // case 2 : select A[i - 1]
                    if (s >= A[i - 1] && j > 0){
                        dp[i][j][s] += dp[i - 1][j - 1][s - A[i - 1]];
                    }
                }
            }
        }
        return dp[A.length][k][target];
    }

    public int kSum(int[] A, int k, int target) {
        // write your code here
        if (A == null || A.length == 0){
            return 0;
        }
        int[][][] dp = new int[2][k + 1][target + 1];
        // initializaiton
        dp[0][0][0] = 1;

        int now = 0, prev = 0;
        //
        for (int i = 1; i <= A.length; i++){
            prev = now;
            now = 1 - prev;
            for (int j = 0; j <= k; j++){
                for (int s = 0; s <= target; s++){
                    // case 1 : not select A[i - 1]
                    dp[now][j][s] = dp[prev][j][s];
                    // case 2 : select A[i - 1]
                    if (s >= A[i - 1] && j > 0){
                        dp[now][j][s] += dp[prev][j - 1][s - A[i - 1]];
                    }
                }
            }
        }
        return dp[now][k][target];
    }
}