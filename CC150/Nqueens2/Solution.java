package com.CC150.Nqueens2;

/**
 * Created by bliu on 4/10/16.
 */

public class Solution {
    public int totalNQueens(int n) {
        if(n <= 0){
            return 0;
        }
        Integer[] column = new Integer[n];
        int counter = helper(n, 0, column, 0);
        return counter;
    }

    public int helper(int n, int row, Integer[] column, int counter){
        int unique = counter;
        if(row == n){
            unique++;
            return unique;
        }
        else{
            for(int col = 0; col < n; col++){
                if(isValid(column, row, col)){
                    column[row] = col;
                    unique = helper(n, row + 1, column.clone(), unique);
                }
            }
        }
        return unique;
    }

    public boolean isValid(Integer[] column, int row, int col){
        for(int row1 = 0; row1 < row; row1++){
            int col1 = column[row1];
            if(col == col1){
                return false;
            }
            int row_diff = Math.abs(row - row1);
            int col_diff = Math.abs(col - col1);
            if(row_diff == col_diff)
                return false;
        }
        return true;
    }

}
