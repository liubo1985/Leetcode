package com.CC150.MultiplyStrings;

/**
 * Created by bliu on 4/6/16.
 */

public class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null)
            return "0";
        int num1Len = num1.length();
        int num2Len = num2.length();
        int[] result = new int[num1Len + num2Len];
        int i, j;

        for(i = num1Len - 1; i >= 0; i--){
            int digit = (int)(num1.charAt(i) - '0');
            int carry = 0;
            for(j = num2Len - 1; j >= 0; j--){
                int product = carry + result[i + j + 1] + digit * (int)(num2.charAt(j) - '0');
                carry = product/10;
                result[i + j + 1] = product%10;

            }
            result[i + j + 1] = carry;
        }
        StringBuilder sb = new StringBuilder();
        int q = 0;
        //把最后一位空出来，万一最后一位是0
        while(q < result.length - 1 && result[q] == 0){
            q++;
        }

        for(int s = q; s < result.length; s++){
            //if(result[s] != 0){
            sb.append(result[s]);
            //}
        }

        //while (q < result.length - 1 && result[q] == 0) {
        //    q++;
        //}

        //while (q < result.length) {
        //    sb.append(result[q++]);
        //}

        return sb.toString();
    }
}
