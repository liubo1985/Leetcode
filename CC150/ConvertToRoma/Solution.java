package com.CC150.ConvertToRoma;

/**
 * Created by bliu on 3/13/16.
 */
public class Solution {

    static final int[] digit =     new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static final String[] symbol = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public String intToRoman(int num) {
        if(num < 1 || num > 3999){
            return null;
        }


        StringBuffer s = new StringBuffer();

        for(int i = 0; i < digit.length && num > 0; i++){
            int r = num / digit[i];

            for(int j = 0; j < r; j++){
                s.append(symbol[i]);
            }
            num %= digit[i];
        }
        return s.toString();
    }
}