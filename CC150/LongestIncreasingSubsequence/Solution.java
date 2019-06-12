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

    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if (s == null || s.length() == 0){
            return false;
        }

        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        int max = maxLen(s, dict);
        for (int i = 1; i <= s.length(); i++){
            res[i] = false;
            for (int j = 0; j < i; j++){
                if (i - j > max || !res[j]){
                    continue;
                }
                String str = s.substring(j, i);
                if (dict.contains(str)){
                    res[i] = true;
                }
            }
        }
        return res[s.length()];
    }