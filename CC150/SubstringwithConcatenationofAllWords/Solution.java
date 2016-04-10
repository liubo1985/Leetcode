package com.CC150.SubstringwithConcatenationofAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bliu on 3/22/16.
 */
public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        if(s == null || words.length == 0)
            return null;
        List<Integer> res = new ArrayList<Integer>();
        Map<String, Integer> hashtable = new HashMap<String, Integer>();
        //Map<String, Integer> checkHashtable = new HashMap<String, Integer>();
        int m = s.length(), l = words.length, n = words[0].length();

        //create hash table for each word
        for(int i = 0; i < l; i++){
            if(hashtable.containsKey(words[i])){
                hashtable.put(words[i], hashtable.get(words[i]) + 1);

            }
            else{
                hashtable.put(words[i], 1);
            }
        }

        //check if there are string concatanation in the string s
        int i = 0;
        while((m - i) >= l*n ){
            Map<String, Integer> checkHashtable = new HashMap<String, Integer>(hashtable);
            for(int j = 0; j < l; j++){
                String substring = s.substring(i + j*n, i + (j + 1)*n);
                if(checkHashtable.containsKey(substring)){


                    if(checkHashtable.get(substring) - 1 == 0){
                        checkHashtable.remove(substring);
                    }
                    else
                        checkHashtable.put(substring, checkHashtable.get(substring) - 1);
                }
                else{
                    break;
                }

            }
            if(checkHashtable.size() == 0){
                res.add(i);
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args){
        String s = "ababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "ababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "ababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "ababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "ababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "ababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "ababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "ababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "ababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "ababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababab";
        String[] words = {"ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab",
                "ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab",
                "ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab",
                "ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab",
                "ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab",
                "ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab",
                "ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab",
                "ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab",
                "ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab",
                "ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab",
                "ba","ab","ba"};

        Solution sol = new Solution();
        List<Integer> al = sol.findSubstring(s, words);
        for(int i = 0; i < al.size(); i++){
            System.out.println("Index is: " + al.get(i));
        }

    }
}
