package com.CC150.LetterCombinationsofAPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bliu on 3/14/16.
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();

        if(digits == null || digits.equals("")){
            return result;
        }

        Map<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('0', new char[]{});
        map.put('1', new char[]{});
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v'});
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });

        StringBuilder sb = new StringBuilder();
        helper(map, result, sb, digits);
        return result;
    }

    private void helper(Map<Character, char[]> map, ArrayList<String> result, StringBuilder sb, String digits){
        //Base case
        if(sb.length() == digits.length()){
            result.add(sb.toString());
            return;
        }

        for(char c : map.get(digits.charAt(sb.length()))){
            sb.append(c);
            helper(map, result, sb, digits);
            sb.deleteCharAt(sb.length()-1);
        }


    }
}