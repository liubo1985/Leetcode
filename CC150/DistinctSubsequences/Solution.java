package CC150.DistinctSubsequences;

/**
 * Created by bliu on 6/21/2016.
 */
public class Solution {
    public int numDistinct(String s, String t) {
        //corner case
        if(t == null){
            return s.length();
        }
        if(s == null){
            return 0;
        }

        //state
        int[][] cache = new int[s.length() + 1][t.length() + 1];
        //initialization
        for(int i = 0; i <=s.length(); i++){
            cache[i][0] = 1;
        }
        //for(int j = 0; j <= t.length(); j++){
        //        cache[0][j] = 0;
        //}

        //function
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= t.length(); j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    //if first i equals first j, the count should be first i - 1 first j - 1 add S 取前i - 1，因为第i个element可能也等于t.charAt(j - 1)
                    cache[i][j] = cache[i - 1][j - 1] + cache[i - 1][j];
                }
                else{
                    cache[i][j] = cache[i - 1][j];
                }
            }
        }
        return cache[s.length()][t.length()];

    }
}
