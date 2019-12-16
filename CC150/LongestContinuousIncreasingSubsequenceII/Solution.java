public class Solution {
    /**
     * @param matrix: A 2D-array of integers
     * @return: an integer
     */
    int[][] cache;

    public int longestContinuousIncreasingSubsequence2(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                cache[i][j] = search(matrix, i, j);
                res = Math.max(res, cache[i][j]);
            }
        }
        return res;
    }

    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{-1, 1, 0, 0};

    private int search(int[][] matrix, int x, int y) {
        if (cache[x][y] != 0) {
            return cache[x][y];
        }
        cache[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX < 0 || newX >= matrix.length || newY < 0 || newY >= matrix[0].length) {
                continue;
            }
            if (matrix[x][y] > matrix[newX][newY]) {
                cache[newX][newY] = search(matrix, newX, newY);
                cache[x][y] = Math.max(cache[x][y], cache[newX][newY] + 1);
            }
        }
        return cache[x][y];
    }
}