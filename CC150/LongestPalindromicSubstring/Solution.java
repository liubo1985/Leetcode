public class Solution {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        if (s == null || s.length() <= 1) {
            return s;
        }

        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int start = 0, length = 1;

        for (int i = 0; i < n; i++){
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++){
            isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (isPalindrome[i][i + 1]){
                length = 1;
                start = i;
            }
        }
        for (int len = 2; len < n; len++){
            for (int j = 0; j + len < n; j++){
                isPalindrome[j][j + len] = (isPalindrome[j + 1][j + len - 1] && (s.charAt(j) == s.charAt(j + len)));
                if (isPalindrome[j][j + len] && len > length){
                    length = len;
                    start = j;
                }
            }
        }
        return s.substring(start, start + length + 1);
    }
}