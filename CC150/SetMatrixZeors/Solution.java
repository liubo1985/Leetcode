package CC150.SetMatrixZeors;

/**
 * Created by bliu on 4/21/16.
 */

public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0){
            return;
        }

        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        //traverse the matrix, find rows and columns which are 0
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(row[i] || col[j]){
                    matrix[i][j] = 0;

                }
            }
        }
    }
}
