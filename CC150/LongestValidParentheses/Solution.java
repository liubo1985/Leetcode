package com.CC150.LongestValidParentheses;

import java.util.Stack;

/**
 * Created by bliu on 3/29/16.
 */
public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() <= 1){
            return 0;
        }

        int maxlength = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int start = -1;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            } else if (!stack.empty()){
                // pair ( and ) and remove (
                stack.pop();
                //after pair, if no has ( left, calculate maxlength, e.g. ()()(), ())()()
                if(stack.empty()){
                    maxlength = Math.max(i - start, maxlength);
                } else {//if has ( left, calculate maxlength, ((()))
                    maxlength = Math.max(i - (int)stack.peek(), maxlength);
                }

            }else {
                start = i;
            }
        }
        return maxlength;
    }
}




