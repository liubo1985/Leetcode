package CC150.Triangle;

import java.util.List;

/**
 * Created by bliu on 5/24/16.
 */

public class Solution {
    int[][] cache;
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return Integer.MAX_VALUE;
        }
        int row = triangle.size();
        cache = new int[row][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                cache[i][j] = Integer.MAX_VALUE;
            }
        }
        int sum = helper(triangle, 0, 0);
        return sum;
    }

    public int helper(List<List<Integer>> triangle, int x, int y){
        if(x >= triangle.size()){
            return 0;
        }

        if(cache[x][y] != Integer.MAX_VALUE){
            return cache[x][y];
        }

        int left = helper(triangle, x + 1, y);
        int right = helper(triangle, x + 1, y + 1);
        cache[x][y] = Math.min(left, right) + triangle.get(x).get(y);

        return cache[x][y];
    }
}