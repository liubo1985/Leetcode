package com.practice.eightQueens;

import java.util.ArrayList;

/**
 * Created by bliu on 11/12/15.

 */
public class EightQueens {

    public static final int GRID_SIZE = 9;

    public static void placeEightQueens (int row, Integer[] columns, ArrayList<Integer[]> results)
    {
        if(row == GRID_SIZE)
        {
            results.add(columns);

        }

        else
        {
            for(int column = 0; column < GRID_SIZE; column++)
            {
                if(isSafe(columns, row, column))
                {
                    columns[row] = column;
                    placeEightQueens(row + 1, columns.clone(), results);
                }
            }

        }
    }

    public static boolean isSafe(Integer[] columns, int row, int col)
    {
        for(int row_spot = 0; row_spot < row; row_spot++)
        {
            int col_spot = columns[row_spot];

            if(col_spot == col)
            {
                return false;
            }

            int row_diff = row - row_spot;
            int col_diff = Math.abs(col_spot - col);

            if(row_diff == col_diff)
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        int row = 0;
        Integer[] columns = new Integer[9];
        ArrayList<Integer[]> results = new ArrayList<Integer[]>();
        int count = 0;

        placeEightQueens(row, columns, results);

        for(Integer[] result : results)
        {
            System.out.println("One of the solution is: ");
            for(int i = 0; i < result.length; i++)
            {

                for(int j = 0; j < result.length; j++)
                {
                    if(result[i] == j)
                    {
                        System.out.print("O ");
                    }
                    else
                    {
                        System.out.print("X ");
                    }

                }
                System.out.println();
            }
            count++;

        }
        System.out.println("Total solution is: " + count);
    }
}
