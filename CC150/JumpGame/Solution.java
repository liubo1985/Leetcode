package CC150.JumpGame;

/**
 * Created by bliu on 4/11/16.
 */

public class Solution {
    public boolean canJump(int[] nums) {

        int start = 0;
        int end = 0;
        int max = 0;
        while(end < nums.length){
            int pre = max;
            for(int i = start; i <= end; i++){
                if(max >= nums.length - 1)
                    return true;
                if(i + nums[i] > max){
                    max = i + nums[i];
                }
            }
            start = end+1;
            end = max;

            if(max == pre)
                return false;
        }
        return true;
    }
}