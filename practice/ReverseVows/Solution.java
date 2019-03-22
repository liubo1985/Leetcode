package practice.ReverseVows;

import java.util.HashSet;

public class Solution {
    public String reverseVows(String s){
        HashSet<Character> set = new HashSet<Character>();
        set.add('A');
        set.add('a');
        set.add('E');
        set.add('e');
        set.add('I');
        set.add('i');
        set.add('O');
        set.add('o');
        set.add('U');
        set.add('u');
        char[] array = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while(left <= right){
            while(left <= right && !set.contains(array[left])){
                left++;
            }
            while(left <= right && !set.contains(array[right])){
                right--;
            }
            if(left <= right){
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return array.toString();
    }

    public void swap(char[] array, int left, int right){
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args){
        String s = "International";
        Solution sol = new Solution();
        String res = sol.reverseVows(s);
        System.out.println("After reverse: " + res);
    }
}
