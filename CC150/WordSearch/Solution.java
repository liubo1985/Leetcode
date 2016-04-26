package CC150.WordSearch;

/**
 * Created by bliu on 4/26/16.
 * 这道题很容易感觉出来是图的题目，其实本质上还是做深度优先搜索。基本思路就是从某一个元素出发，往上下左右深度搜索是否有相等于word的
 * 字符串。这里注意每次从一个元素出发时要重置访问标记（也就是说虽然单次搜索字符不能重复使用，但是每次从一个新的元素出发，字符还是
 * 重新可以用的）。深度优先搜索的算法就不再重复解释了，不了解的朋友可以看看wiki - 深度优先搜索。我们知道一次搜索的复杂度是O(E+V)，
 * E是边的数量，V是顶点数量，在这个问题中他们都是O(m*n)量级的（因为一个顶点有固定上下左右四条边）。加上我们对每个顶点都要做一次搜索，
 * 所以总的时间复杂度最坏是O(m^2*n^2)，空间上就是要用一个数组来记录访问情况，所以是O(m*n)。
 */

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0){
            return false;
        }
        if(word.length() == 0){
            return true;
        }
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        int index = 0;
        boolean res = false;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){

                if(search(board, word, index, i, j, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word, int index, int i, int j, boolean[][] visited){
        if(index == word.length()){
            return true;
        }
        if(j < 0 || i < 0 || i > board.length - 1 || j > board[0].length - 1 || visited[i][j] || board[i][j] != word.charAt(index)){
            return false;
        }
        visited[i][j] = true;
        boolean res = search(board,word,index+1,i-1,j,visited)
                || search(board,word,index+1,i+1,j,visited)
                || search(board,word,index+1,i,j-1,visited)
                || search(board,word,index+1,i,j+1,visited);
        visited[i][j] = false;
        return res;
    }
}
