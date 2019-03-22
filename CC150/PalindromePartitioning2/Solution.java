package CC150.PalindromePartitioning2;

/**
 * Created by bliu on 5/31/2016.
 */

public class Solution {

    public boolean[][] precompute(String s){
        boolean[][] isPanlindrome = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            isPanlindrome[i][i] = true;
        }
        for(int i = 0; i < s.length() - 1; i++){
            isPanlindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for(int length = 2; length < s.length(); length++){
            for(int i = 0; i + length < s.length(); i++){
                isPanlindrome[i][i + length] = (isPanlindrome[i + 1][i + length -1] && s.charAt(i) == s.charAt(i + length));

            }
        }
        return isPanlindrome;
    }

    public int minCut(String s){
        if(s.length() == 0 || s == null){
            return 0;
        }
        boolean[][] isPanlindrome = precompute(s);
        int[] mincut = new int[s.length() + 1];
        mincut[0] = 0;

        for(int i = 1; i <= s.length(); i++){
            int min = i;
            for(int j = 0; j < i; j++){
                if(isPanlindrome[j][i - 1] == true){
                    min = Math.min(min, mincut[j] + 1);
                }

            }
            mincut[i] = min;
        }
        return mincut[s.length()] - 1;
    }
}