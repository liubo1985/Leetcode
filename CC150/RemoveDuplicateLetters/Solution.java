package CC150.RemoveDuplicatesfromSortedArray2;

/**
 * Created by bliu on 4/26/2016.
 * Given a string s which contains only lowercase letters, remove duplicate letters so that every letter appear
 * once and only once. You must make sure your result is the smallest in lexicographical order among all possible
 * results.

 Example
 Example1

 Input: s = "bcabc"
 Output: "abc"
 Example2

 Input: s = "cbacdcbc"
 Output: "acdb"
 */

public class Solution {
    /**
     * @param s: a string
     * @return: return a string
     */
    public String removeDuplicateLetters(String s) {
        // write your code here
        if (s == null || s.length() == 0){
            return "";
        }

        int[] count = new int[26];
        boolean[] visit = new boolean[26];
        Stack<Integer> stack = new Stack<Integer>();

        for(char ch : s.toCharArray()){
            count[ch - 'a']++;
        }

        for (char ch : s.toCharArray()){
            int index = ch - 'a';
            count[index]--;
            if (visit[index]){
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > index && count[stack.peek()] > 0){

                visit[stack.peek()] = false;
                stack.pop();
            }
            stack.push(index);
            visit[index] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, (char)('a' + stack.pop()));
        }
        return sb.toString();
    }
}