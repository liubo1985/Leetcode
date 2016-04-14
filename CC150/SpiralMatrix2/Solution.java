package CC150.SpiralMatrix2;

/**
 * Created by bliu on 4/13/16.
 */

public class Solution {
    public int[][] generateMatrix(int n) {
        if(n <= 0){
            return new int[0][0];
        }
        int leftMost = 0;
        int rightMost = n - 1;
        int topMost = 0;
        int botomMost = n - 1;
        int counter = 1;
        int[][] res = new int[n][n];

        while(true){
            for(int i = leftMost; i <= rightMost; i++){
                res[topMost][i] = counter++;
            }
            if(++topMost > botomMost)
                break;

            for(int i = topMost; i <= botomMost; i++){
                res[i][rightMost] = counter++;
            }
            if(--rightMost < leftMost)
                break;

            for(int i = rightMost; i >= leftMost; i--){
                res[botomMost][i] = counter++;
            }
            if(--botomMost < topMost)
                break;

            for(int i = botomMost; i >= topMost; i--){
                res[i][leftMost] = counter++;
            }
            if(++leftMost > rightMost)
                break;
        }

        return res;

    }
}