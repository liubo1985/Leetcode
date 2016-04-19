package CC150.MinimumPathSum;

/**
 * Created by bliu on 4/17/16.
 */


public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] cache = new int[m][n];
        cache[0][0] = grid[0][0];
        //first row is 1, because only one way to move on the first row
        for(int i = 1; i < n; i++){
            cache[0][i] = grid[0][i] + cache[0][i - 1];
        }

        // first column is 1, because only on way to move on the first column
        for(int i = 1; i < m; i++){
            cache[i][0] = grid[i][0] + cache[i - 1][0];
        }

        //cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                cache[i][j] = Math.min(cache[i - 1][j], cache[i][j - 1]) + grid[i][j];
            }
        }
        return cache[m -1][n -1];
    }
}