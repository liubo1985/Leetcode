package com.CC150.GroupAnagrams;

import java.util.*;

/**
 * Created by bliu on 4/8/16.
 * 判断两个词是否是变形词，最简单的方法是将两个词按字母排序，看结果是否相同。这题中我们要将所有同为一个变形词词根的词归到一起，
 * 最快的方法则是用哈希表。所以这题就是结合哈希表和排序。我们将每个词排序后，根据这个键值，找到哈希表中相应的列表，并添加进去。
 * 为了满足题目字母顺序的要求，我们输出之前还要将每个列表按照内部的词排序一下。可以直接用Java的Collections.sort()这个API。
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null)
            return null;
        Map<String, List<String>> hashmap = new HashMap<String, List<String>>();
        List<String> list = new ArrayList<String>();
        for(String str : strs){
            char[] cha = str.toCharArray();
            //sort the word, first convert to char array, then sort the array
            Arrays.sort(cha);
            String s = new String(cha);
            if(hashmap.containsKey(s)){
                list = hashmap.get(s);
                list.add(str);
            }
            else{
                list = new ArrayList<String>();
                list.add(str);
            }
            hashmap.put(s,list);
        }
        //sort the list, use collections sort
        List<List<String>> res = new ArrayList();
        for(String key : hashmap.keySet()){
            List<String> value = hashmap.get(key);
            Collections.sort(value);
            res.add(value);
        }
        return res;
    }
}