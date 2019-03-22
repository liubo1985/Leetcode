package CC150.LongestSubstringWith2UniqueCharacters;

/**
 * Created by bliu on 6/28/2016.
 */

import java.util.HashMap;

public class Solution {
    public int maxLength(String s){
        int start = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            char cha = s.charAt(i);
            if(!map.containsKey(cha)){
                map.put(cha, 1);
            }
            else{
                map.put(cha, map.get(cha) + 1);
            }
            if(map.size() > 2){
                max = Math.max(max, i - start);

                while(map.size() > 2){
                    char left = s.charAt(start);
                    int count = (int)map.get(left);
                    if(count <= 1){
                        map.remove(left);
                    }
                    else{
                        map.put(left, count - 1);
                    }
                    start++;
                }
            }
        }
        max = Math.max(max, s.length() - start);
        return max;
    }

    public static void main(String[] args){
        String s = "abcbbbbcccbdddadacb";
        Solution sol = new Solution();
        int max = sol.maxLength(s);
        System.out.println("The result is: " + max);
    }

}
