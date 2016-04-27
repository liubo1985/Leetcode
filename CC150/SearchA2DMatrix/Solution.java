package CC150.SearchA2DMatrix;

/**
 * Created by bliu on 4/21/16.
 */

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }
        if(matrix[0][0] > target)
            return false;

        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int start = 0;
        int end = row;
        //locate the row
        while(start <= end){
            int mid = start + (end - start)/2;
            if(matrix[mid][0] == target){
                return true;
            }
            else if(matrix[mid][0] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        //locate the column
        row = end;
        start = 0;
        end = col;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(matrix[row][mid] == target){
                return true;
            }
            else if(matrix[row][mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return false;
    }
}
