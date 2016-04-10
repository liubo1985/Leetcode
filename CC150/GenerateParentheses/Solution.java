package com.CC150.GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bliu on 3/15/16.
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        if(n <= 0){
            return new ArrayList<String>();
        }

        List<String> result = new ArrayList<String>();
        String paren = "";
        int left_paren = n;
        int right_paren = n;


        getParen(result, paren, left_paren, right_paren);

        return result;
    }

    private void getParen(List<String> result, String paren, int left_paren, int right_paren){
        if(left_paren == 0 && right_paren == 0){
            result.add(paren);
            return;
        }
        if(left_paren > 0){
            String left_side = paren + "(";
            getParen(result, left_side , left_paren - 1, right_paren);
        }
        if(right_paren > 0 && right_paren > left_paren){
            String right_side = paren + ")";
            getParen(result, right_side, left_paren, right_paren - 1);
        }
    }

}
