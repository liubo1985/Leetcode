package com.CC150.SudokuSolver;

/**
 * Created by bliu on 3/30/16.
 * * 1 每个backtracking的题目，最好都有独立判断isValid的程序，这样架构清楚。同时，valid判断函数在这里可以稍微研究一下。只要当前要判断的
 * 位置上的数值和本行没有重复，本列没有重复，九宫格没有重复就可以。一旦重复立即返回，减少判断次数。
 2 backtracking的递归函数，怎么能没有返回值呢？！因为要判断递归的方案正确与否，所以这里的递归一定是有返回值的（除非是combination那种
 没有正确错误概念的backtracking）！
 3 可以考虑“先放置，再判断”的方案。比如这里，首先判断当前位置是否为空，如果为空，那么放置一个元素，检查它是否正确。如果正确，就继续进行
 下面的递归（也就是第29行 isValid&&solveSudoku的作用）。当函数返回错误之后，将刚刚的数值变为空，再进行下一次尝试即可。
 4 所有的方案（k从1到9）完毕之后，应该返回错误，这个是不应该被忽略的。
 5 最后一点需要注意的是，当i,j循环完毕之后，第36行应该返回true。这里实际上是最终/最底层的一次循环，表明已经解出了sudoku，返回true！
 切记切记，最终情况！
 */


public class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(int k = 1; k <= 9; k++){
                        board[i][j] = (char)('0' + k);
                        if(isValid(board, i, j) && solve(board)){
                            return true;
                        }
                        else{
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int x, int y){
        for(int i = 0; i < 9; i++){
            if(i != x && board[i][y] == board[x][y]){
                return false;
            }
        }

        for(int j = 0; j < 9; j++){
            if(j != y && board[x][j] == board[x][y]){
                return false;
            }
        }

        for(int i = 3*(x/3); i < 3*(x/3) + 3; i++){
            for(int j = 3*(y/3); j < 3*(y/3) + 3; j++){
                if(x != i && y != j && board[x][y] == board[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}