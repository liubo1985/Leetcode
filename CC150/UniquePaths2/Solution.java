package CC150.UniquePaths2;

/**
 * Created by bliu on 4/16/16.
 */

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int res = 0;
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        cache = new int[row][column];
        res = helper(row, column, obstacleGrid);
        return res;
    }


    private int[][] cache;

    public int helper(int m, int n, int[][] obstacleGrid){
        if(m < 1 || n < 1 || obstacleGrid[m-1][n-1] == 1){
            return 0;
        }
        if(m == 1 && n == 1){
            return 1;
        }
        return getCache(m - 1, n, obstacleGrid) + getCache(m, n - 1, obstacleGrid);
    }

    public int getCache(int m, int n, int[][] obstacleGrid){
        //Boundary case, otherwise overflow
        if(m == 0 || n == 0 || obstacleGrid[m-1][n-1] == 1){
            return 0;
        }
        if(cache[m-1][n-1] > 0){
            return cache[m-1][n-1];
        }
        cache[m-1][n-1] = helper(m, n, obstacleGrid);
        return cache[m-1][n-1];
    }

}
