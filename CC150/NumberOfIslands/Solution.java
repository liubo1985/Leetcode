package CC150.NumberOfIslands;

/**
 * Created by bliu on 7/18/2016.
 */

public class Solution {

    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {0, 1, 0, -1};

    public void visit(char[][] grid, int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
            return;
        }
        if(grid[x][y] == '1'){
            grid[x][y] = '0';
            for(int i = 0; i < 4; i++){
                visit(grid, x + dx[i], y + dy[i]);
            }
        }

    }

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int count = 0;
        for(int x = 0; x < grid.length; x++){
            for(int y = 0; y < grid[0].length; y++){
                if(grid[x][y] == '1'){
                    count++;
                    visit(grid, x, y);
                }
            }
        }
        return count;
    }
}
