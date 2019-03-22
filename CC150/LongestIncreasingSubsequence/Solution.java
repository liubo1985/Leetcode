package CC150.LongestIncreasingSubsequence;

/**
 * Created by bliu on 6/1/2016.
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            lis[i] = 0;
        }
        for(int i = 0; i < nums.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    max = Math.max(max, lis[j]);
                }
            }
            lis[i] = max + 1;
        }
        int maxSequence = 0;
        for(int i = 0; i < lis.length; i++){
            maxSequence = Math.max(maxSequence, lis[i]);
        }
        return maxSequence;
    }
}