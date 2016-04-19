package CC150.UniquePaths;

/**
 * Created by bliu on 4/16/16.
 */

public class Solution2 {

    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        //first row is 1, because only one way to move on the first row
        for(int i = 0; i < n; i++){
            cache[0][i] = 1;
        }

        // first column is 1, because only on way to move on the first column
        for(int i = 0; i < m; i++){
            cache[i][0] = 1;
        }

        //cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
            }
        }
        return cache[m -1][n -1];

    }

}