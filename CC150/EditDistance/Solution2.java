public class Solution {
    /**
     * @param word1: A string
     * @param word2: A string
     * @return: The minimum number of steps.
     */

    // memory optimization, O(mn) -> O(n)
    public int minDistance(String word1, String word2) {
        // write your code here
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();

        if (word1Array.length == 0 && word2Array.length == 0){
            return 0;
        }
        int m = word1Array.length;
        int n = word2Array.length;

        int[][] dp = new int[2][n + 1];
        int prev = 0, now = 0;

        for (int i = 0; i <= m; i++){
            prev = now;
            now = 1 - prev;
            for (int j = 0; j <= n; j++){
                if (i == 0) {
                    dp[now][j] = j;
                    continue;
                }
                if (j == 0){
                    dp[now][j] = i;
                    continue;
                }
                if (word1Array[i - 1] != word2Array[j - 1]){
                    dp[now][j] = Math.min(dp[prev][j] + 1, dp[now][j - 1] + 1);
                    dp[now][j] = Math.min(dp[now][j], dp[prev][j - 1] + 1);
                }
                if (word1Array[i - 1] == word2Array[j - 1]){
                    dp[now][j] = dp[prev][j - 1];
                }
            }
        }
        return dp[now][n];
    }
}