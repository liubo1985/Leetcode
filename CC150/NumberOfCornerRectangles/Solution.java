public class Solution {
    /**
     * @param grid: the grid
     * @return: the number of corner rectangles
     */

    //两行同时遍历，如果两行中相同列位置的值都为1，则计数器count加1.
    //但是两列都是1才是个长方形，所以共有count*(count-1)/2个.

    public int countCornerRectangles(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0){
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length - 1; i++){
            for (int j = i + 1; j < grid.length; j++){
                int count = 0;
                for (int k = 0; k < grid[0].length; k++){
                    if (grid[i][k] == 1 && grid[j][k] == 1){
                        count++;
                    }
                }
                res += count * (count - 1) / 2;
            }
        }
        return res;
    }
}