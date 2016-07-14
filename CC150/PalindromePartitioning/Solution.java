package CC150.PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bliu on 7/4/2016.
 */

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if(s == null || s.length() == 0){
            return results;
        }
        List<String> path = new ArrayList<String>();
        helper(s, 0, path, results);
        return results;
    }

    public boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public void helper(String s, int pos, List<String> path, List<List<String>> results){
        if(pos == s.length()){
            results.add(path);
            return;
        }

        for(int i = pos; i < s.length(); i++){
            String substring = s.substring(pos, i + 1);
            if(!isPalindrome(substring)){
                continue;
            }

            path.add(substring);
            helper(s, i + 1, new ArrayList<String>(path), results);
            path.remove(path.size() - 1);
        }
    }
}

