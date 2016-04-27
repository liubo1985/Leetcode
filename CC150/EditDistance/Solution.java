package CC150.EditDistance;

/**
 * Created by bliu on 4/21/2016.
 * If last characters of two strings are same, nothing much to do. Ignore last characters and get count for
 * remaining strings. So we recur for lengths m-1 and n-1.
 Else (If last characters are not same), we consider all operations on ‘str1′, consider all three operations
 on last character of first string, recursively compute minimum cost for all three operations and take minimum
 of three values.
 Insert: Recur for m and n-1
 Remove: Recur for m-1 and n
 Replace: Recur for m-1 and n-1
 */

public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0 && word2.length() == 0){
            return 0;
        }
        int word1_len = word1.length();
        int word2_len = word2.length();
        //
        int[][] dist = new int[word1_len+1][word2_len+1];
        for(int i = 0; i <= word1_len; i++){
            dist[i][0] = i;
        }

        for(int i = 0; i <= word2_len; i++){
            dist[0][i] = i;
        }

        for(int i = 1; i <= word1_len; i++){
            for(int j = 1; j <= word2_len; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dist[i][j] = dist[i - 1][j - 1];
                }
                else{
                    dist[i][j] = Math.min(Math.min(dist[i][j - 1], dist[i - 1][j]), dist[i - 1][j - 1]) + 1;
                }
            }
        }
        return dist[word1_len][word2_len];
    }
}
