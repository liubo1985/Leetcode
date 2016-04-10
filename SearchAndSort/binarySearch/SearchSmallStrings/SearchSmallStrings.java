package com.SearchAndSort.binarySearch.SearchSmallStrings;


import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by bliu on 2/5/16.
 */
public class SearchSmallStrings {

    public static ArrayList<Integer> searchAll(String longString, String[] shortString){
        SuffixTree root = new SuffixTree(longString);

        ArrayList<Integer> list = new ArrayList<Integer>(shortString.length);
        for(String ss : shortString)
            list.add(root.search(ss));
        return list;
    }

    public static void main(String[] args){
        String longString = "nationality";
        String[] shortString = {"nation", "tion", "nality", "li"};
        ArrayList<Integer> results = searchAll(longString, shortString);

        for(int i = 0; i < shortString.length; i++){
            System.out.println("the string" + shortString[i] + "is: " + results.get(i));
        }
    }

    public static class SuffixNode{
        public char ch;
        public int index;
        public Hashtable<Character, SuffixNode> children;

        public SuffixNode(char ch){
            this.ch = ch;
            this.index = -1;
            this.children = new Hashtable<Character, SuffixNode>();
        }
    }

    public static class  SuffixTree{
        public SuffixNode root;

        public SuffixTree(String str){
            root = new SuffixNode('#');
            for(int i = 0; i < str.length(); i++){
                insert(root, str.substring(i), i);
            }
        }

        public void insert(SuffixNode curNode, String suffix, int index){
            if(suffix.length() == 0)
                return;
            char ch = suffix.charAt(0);
            SuffixNode node = curNode.children.get(ch);

            if(node == null){
                node = new SuffixNode(ch);
                curNode.children.put(ch,node);
                node.index = index;
            }

            insert(node, suffix.substring(1), index + 1);

        }

        public int search(String search){
            return search(search, search , root);
        }

        public int search(String original, String search, SuffixNode curNode){
            //if the short string exists, return 0, otherwise return -1
            if(search.length() == 0)
                return curNode.index + 1 - original.length();

            char ch = search.charAt(0);

            SuffixNode node = curNode.children.get(ch);
            if (node == null)
                return -1;
            else
                return search(original, search.substring(1), node);
        }


    }
}
