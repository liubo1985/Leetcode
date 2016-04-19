package CC150.UniquePaths2;

/**
 * Created by bliu on 4/17/16.
 */

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] cache = new int[m][n];
        //first row is 1, because only one way to move on the first row
        for(int i = 0; i < n; i++){
            if(obstacleGrid[0][i] == 1){
                break;
            }else{
                cache[0][i] = 1;
            }
        }

        // first column is 1, because only on way to move on the first column
        for(int i = 0; i < m; i++){
            if(obstacleGrid[i][0] == 1){
                break;
            }else{
                cache[i][0] = 1;
            }
        }

        //cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    cache[i][j] = 0;
                }
                else{
                    cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
                }
            }
        }
        return cache[m -1][n -1];
    }

}
