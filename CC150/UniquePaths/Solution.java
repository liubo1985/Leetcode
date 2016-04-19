package CC150.UniquePaths;

/**
 * Created by bliu on 4/16/16.
 */


public class Solution {
    private int[][] cache;
    public int uniquePaths(int m, int n) {
        int res = 0;
        cache = new int[m][n];
        res = helper(m, n);
        return res;
    }

    public int helper(int m, int n){
        if(m < 1 || n < 1){
            return 0;
        }
        if(m == 1 && n == 1){
            return 1;
        }
        return getCache(m - 1, n) + getCache(m, n - 1);
    }

    public int getCache(int m, int n){
        //Boundary case, otherwise overflow
        if(m == 0 || n == 0){
            return 0;
        }
        if(cache[m-1][n-1] > 0){
            return cache[m-1][n-1];
        }
        cache[m-1][n-1] = helper(m, n);
        return cache[m-1][n-1];
    }
}