package com.StringProb.rotateImage;

/**
 * Created by bliu on 2/15/16.
 *
 * Given an image represented by an NxN matrix, where eah pixel in the image is 4 bytes, write a metohd to rotate
 * the image by 90 degrees. Cn you do this in place?
 */
public class RotateImage {

    public void rotate(int[][] matrix, int n){
        if (matrix == null)
            return;

        for(int layer = 0; layer < n/2; layer++){
            int first = layer;
            int last = n - 1 - first;

            for(int i = first; i < last; i++){
                int offset = i - first;

                //top -> temp
                int temp = matrix[first][i];

                //left -> top
                matrix[first][i] = matrix[last - offset][first];

                //bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                //rigt -> bottom
                matrix[last][last - offset] = matrix[i][last];

                //temp -> right
                matrix[i][last] = temp;
            }
        }
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,2},{3,4}};
        System.out.println("the original matrix is: ");
        for(int i = 0; i < matrix.length; i++){
            System.out.println();
            for (int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println("\n***************************");

        RotateImage newImage = new RotateImage();
        newImage.rotate(matrix, matrix.length);

        System.out.println("the rotated matrix is: ");

        for(int i = 0; i < matrix.length; i++){
            System.out.println();
            for (int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
        }


    }
}
