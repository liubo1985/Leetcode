package com.CC150.CountandSay;

/**
 * Created by bliu on 4/1/16.
 */
public class Solution {
    public String countAndSay(int n) {
        int counter;
        String preSay = "1";
        while((--n) > 0){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < preSay.length(); ){
                counter = 1;
                while((i + 1) < preSay.length() && preSay.charAt(i) == preSay.charAt(i+1)){
                    counter++;
                    i++;
                }
                sb.append(String.valueOf(counter));
                sb.append(String.valueOf(preSay.charAt(i)));

                i++;
            }
            preSay = sb.toString();
        }
        return preSay;
    }
}
