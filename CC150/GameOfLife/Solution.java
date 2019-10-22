public class Solution {
    /**
     * @param board: the given board
     * @return: nothing
     */
    int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = new int[]{0, 1, -1, 1, -1, 1, 0, -1};

    public void gameOfLife(int[][] board) {
        // Write your code here
        if (board == null || board.length == 0){
            return;
        }
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                int count = countLive(board, i , j);
                if (board[i][j] == 1 && count < 2){
                    board[i][j] = 1;
                }
                if (board[i][j] == 1 && (count == 2 || count == 3)){
                    board[i][j] = 3;
                }
                if (board[i][j] == 1 && count > 3){
                    board[i][j] = 1;
                }
                if (board[i][j] == 0 && count == 3){
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                board[i][j] /= 2;
            }
        }
    }

    public int countLive(int[][] board, int i, int j){
        int res = 0;
        for (int del = 0; del < 8; del++){
            int nextX = i + dx[del];
            int nextY = j + dy[del];
            if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length){
                continue;
            }
            res += (board[nextX][nextY] & 1) == 1 ? 1 : 0;

        }
        return res;
    }
}