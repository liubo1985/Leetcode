package com.CC150.ConvertRomaToInt;

/**
 * Created by bliu on 3/14/16.
 */
public class Solution {
    public int map(char r){
        switch(r){
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }

    public int romanToInt(String s) {
        int len = s.length();
        int result = 0;
        for(int i = 0; i < len; i++){
            if(i > 0 && map(s.charAt(i)) > map(s.charAt(i - 1))){
                result += map(s.charAt(i)) - 2*map(s.charAt(i - 1));
            }
            else{
                result += map(s.charAt(i));
            }
        }
        return result;
    }
}
