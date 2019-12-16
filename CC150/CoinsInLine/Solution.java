public class Solution {
    /**
     * @param n: An integer
     * @return: A boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        if (n == 0){
            return false;
        }

        if (n == 1 || n == 2){
            return true;
        }

        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = true;
        dp[2] = true;
        for (int i = 3; i <= n; i++){
            // 当还剩下 i 个coins时，当前player做出决策后，对手的胜负情况
            //true, f[i - 1] == false AND f[i - 2] == false
            //true, f[i - 1] == false AND f[i - 2] == true
            //true, f[i - 1] == true AND f[i - 2] == false
            //false, f[i - 1] == true AND f[i - 2] == true
            dp[i] = (dp[i - 1] == false || dp[i - 2] == false) ? true : false;
        }
        return dp[n];
    }
}