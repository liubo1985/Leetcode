package com.StringProb.SetMatrix0;

/**
 * Created by bliu on 2/15/16.
 *
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0
 */
public class SetZeors {

    public static void setZeros(int[][] matrix){
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rows[i] = true;
                    columns[j] = true;
                }

            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(rows[i] || columns[j]){
                    matrix[i][j] = 0;
                }

            }
        }
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{{1, 2, 3, 5, 0},{6, 9, 3, 1, 1}, {5, 6, 4, 2, 4}, {1, 3, 2, 0, 5}};
        System.out.println("the original matrix is: ");
        for(int i = 0; i < matrix.length; i++){
            System.out.println();
            for (int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println("\n***************************");

        setZeros(matrix);
        System.out.println("the modified matrix is: ");

        for(int i = 0; i < matrix.length; i++){
            System.out.println();
            for (int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}
