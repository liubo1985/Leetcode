package CC150.LongestSubstringWithoutRepeatingCharacters;

import java.util.Arrays;

/**
 * Created by bliu on 3/15/16.
 */
public class Solution{
    public int lengthOfLongestSubstring(String s) {
            int[] map = new int[256]; // map from character's ASCII to its last occured index
            Arrays.fill(map, -1);

            int slow = 0;
            int fast = 0;
            int ans = 0;
        //mainten a window of non repeat characters, if find repeat charcter, move left pointer to
        //next character of repeated charater, then move right pointer to next one
            for (fast = 0; fast < s.length(); fast++) {
                int ch = s.charAt(fast);
                while (map[ch]!=-1 && slow < fast) {
                int temp = s.charAt(slow);
                map[temp] = -1;
                slow ++;
                }
                map[ch] = 0;
                ans = Math.max(ans, fast-slow + 1);
            }

            return ans;
            }
}