package com.CC150.WildcardMatching;

public class Solution {
    /**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    public boolean isMatch(String s, String p) {
        // write your code here

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
                    if (j > 0 && i > 0 && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?')){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else { // case 2 : p is *
                    // s[i -1] matches 0 p[j -2], not care *
                    if (j >= 1){
                        dp[i][j] |= dp[i][j - 1];
                    }
                    // first s[i - 2] matches the p[j - 1]
                    if (i >= 1) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                }

            }
        }
        return dp[s.length()][p.length()];
    }
}