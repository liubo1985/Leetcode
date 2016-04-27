package CC150.RemoveDuplicatesfromSortedArray2;

/**
 * Created by bliu on 4/26/2016.
 */

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        //end element of the non duplicate array
        int end = 1;
        int nonDup = nums[0];
        //count start from 2
        int count = 2;
        for(int i = 1; i < nums.length; i++){
            //if num[i] is not equal to non-duplicate element or duplicate element is less than 3, update
            if(nonDup != nums[i] || count < 3){
                //reset count
                if(nonDup != nums[i]){
                    count = 1;
                }
                nums[end++] = nums[i];
                //size++;
                nonDup = nums[i];
            }
            //ipdate count if equal
            if(nonDup == nums[i]){
                count++;
            }
        }
        return end;

    }
}