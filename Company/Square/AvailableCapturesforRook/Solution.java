

class Solution {
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};
    public int numRookCaptures(char[][] board) {
        if (board == null || board.length == 0){
            return 0;
        }
        int res = 0;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'R'){
                    for (int k = 0; k < 4; k++){
                        res += search(board, i, j, dx[k], dy[k]);
                    }
                }
            }
        }
        return res;
    }

    public int search(char[][] board, int x, int y, int dx, int dy){
        int nextX = x + dx;
        int nextY = y + dy;
        while (nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length && board[nextX][nextY] != 'B'){
            if (board[nextX][nextY] == 'p'){
                return 1;
            }
            nextX += dx;
            nextY += dy;
        }
        return 0;
    }
}