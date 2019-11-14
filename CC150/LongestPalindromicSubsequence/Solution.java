public class Solution {
    /**
     * @param s: the maximum length of s is 1000
     * @return: the longest palindromic subsequence's length
     */
    public int longestPalindromeSubseq(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }

        int n = s.length();
        int[][] longestPalindrome = new int[n][n];
        int res = 1;

        for (int i = 0; i < n; i++){
            longestPalindrome[i][i] = 1;
        }
        for (int i = 0; i < n - 1; i++){
            longestPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 2 : 1;
        }
        for (int len = 2; len < n; len++){
            for (int j = 0; j + len < n; j++){
                if (s.charAt(j) == s.charAt(j + len)) {
                    longestPalindrome[j][j + len] = longestPalindrome[j + 1][j + len - 1] + 2;
                } else {
                    longestPalindrome[j][j + len] = Math.max(longestPalindrome[j + 1][j + len], longestPalindrome[j][j + len - 1]);
                }
                res = Math.max(res, longestPalindrome[j][j + len]);

            }
        }
        return res;

    }
}