public class Solution {
    /**
     * @param s: A string
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if (s == null || s.length() == 0 && p.length() != 0){
            return false;
        }
        if (p == null || p.length() == 0 && s.length() != 0){
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++){
                // initilization
                if (i == 0 && j == 0){
                    dp[i][j] = true;
                    continue;
                }
                if (j == 0){
                    dp[i][j] = false;
                    continue;
                }
                // case 1 : character to caaracter match
                if (j > 0 && p.charAt(j - 1) != '*') {
                    if (j > 0 && i > 0 && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.')){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else { // case 2 : p is *
                    // s[i -1] matches 0 p[j -2]
                    if (j >= 2){
                        dp[i][j] |= dp[i][j - 2];
                    }
                    // s[i - 1] matches the last p[p -2]
                    if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                }

            }
        }
        return dp[s.length()][p.length()];
    }
}