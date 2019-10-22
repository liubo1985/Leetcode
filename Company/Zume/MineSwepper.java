public class Solution {
    /**
     * @param board: a board
     * @param click: the position
     * @return: the new board
     */
    int[] x = new int[]{-1, -1, -1, 1, 1, 1, 0, 0};
    int[] y = new int[]{0, 1, -1, 1, 0, -1, 1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        // Write your code here
        if (board == null || board.length == 0 || click[0] < 0 || click[0] > board.length
                || click[1] < 0 || click[1] > board[0].length){
            return board;
        }
        helper(board, click[0], click[1]);
        return board;
    }

    public void helper (char[][] board, int row, int col){
        if (board[row][col] == 'M'){
            board[row][col] = 'X';
            return;
        }

        if (board[row][col] == 'E'){
            int count = counter(board, row, col);
            if (count == 0){
                board[row][col] = 'B';
                for (int i = 0 ; i < 8; i++){
                    int xDel = row + x[i];
                    int yDel = col + y[i];
                    if (xDel < 0 || xDel >= board.length || yDel < 0 || yDel >= board[0].length){
                        continue;
                    }
                    if (board[xDel][yDel] == 'E'){
                        helper(board, xDel, yDel);
                    }
                }
            }else {
                board[row][col] = (char)(count + '0');
            }
        }
    }

    public int counter(char[][] board, int row, int col){
        int res = 0;
        for (int i = 0; i < 8; i++){
            int xDel = row + x[i];
            int yDel = col + y[i];
            if (xDel < 0 || xDel >= board.length || yDel < 0 || yDel >= board[0].length){
                continue;
            }
            if (board[xDel][yDel] == 'M'){
                res++;
            }
        }
        return res;
    }
}