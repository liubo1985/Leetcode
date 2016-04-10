package com.CC150.ValidParentheses;

import java.util.Stack;

/**
 * Created by bliu on 3/14/16.
 */
public class Solution {
    public boolean isValid(String s) {
        if(s == null)
            return false;

        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else{
                if(!stack.isEmpty() && isPaired(stack.peek(), c)){
                    stack.pop();
                }
                else

                    return false;
            }
        }
        return stack.isEmpty();

    }

    private boolean isPaired(char a, char b){
        if((a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' || b == '}'))
            return true;
        return false;
    }


}
