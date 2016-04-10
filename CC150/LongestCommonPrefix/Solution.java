package com.CC150.LongestCommonPrefix;

/**
 * Created by bliu on 3/14/16.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";

        int len = strs[0].length();
        for(int i = 0; i < len; i++){
            for(int j = 1; j < strs.length; j++){
                if(strs[j].length() > i && strs[0].charAt(i) == strs[j].charAt(i)){
                    continue;

                }
                return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }
}