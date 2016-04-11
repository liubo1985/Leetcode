package CC150.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bliu on 4/11/16.
 */


public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return new ArrayList<Integer>();

        List<Integer> res = new ArrayList<Integer>();
        int beginX = 0;
        int endX = matrix[0].length - 1;
        int beginY = 0;
        int endY = matrix.length - 1;

        while(true){
            for(int i = beginX; i <= endX; i++){
                res.add(matrix[beginY][i]);
            }
            if(++beginY > endY)
                break;

            for(int i = beginY; i <= endY; i++){
                res.add(matrix[i][endX]);
            }
            if(--endX < beginX)
                break;

            for(int i = endX; i >= beginX; i--){
                res.add(matrix[endY][i]);
            }
            if(--endY < beginY)
                break;

            for(int i = endY; i >= beginY; i--){
                res.add(matrix[i][beginX]);
            }
            if(++beginX > endX)
                break;
        }

        return res;
    }
}
