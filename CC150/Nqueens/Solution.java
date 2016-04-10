package com.CC150.Nqueens;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bliu on 4/10/16.
 */

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        if(n <= 0){
            return null;
        }
        Integer[] column = new Integer[n];
        List<List<String>> result = new ArrayList();
        helper(n, 0, column, result);
        return result;
    }

    public void helper(int n, int row, Integer[] column, List<List<String>> result){
        if(row == n){
            List<String> list = drawBoard(column, n);
            result.add(list);
        }
        else{
            for(int col = 0; col < n; col++){
                if(isValid(column, row, col)){
                    column[row] = col;
                    helper(n, row + 1, column.clone(), result);

                }

            }
        }
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

    public List<String> drawBoard(Integer[] column, int n){
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < column.length; i++){
            StringBuilder str = new StringBuilder();
            int qPosition = column[i];
            for(int j = 0; j < n; j++){
                if(j != qPosition){
                    str.append(".");
                }
                else{
                    str.append("Q");
                }
            }
            list.add(str.toString());
        }
        return list;
    }
}

