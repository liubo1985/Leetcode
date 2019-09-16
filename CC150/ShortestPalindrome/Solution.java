public class Solution {
    /**
     * @param str: String
     * @return: String
     */

    // Find the longest palindrome from index 0, then reverse the leftover and insert into head

    public String shortestPalindrome(String str) {
        // Write your code here
        if (str == null || str.length() == 0){
            return "";
        }
        int i = str.length() - 1;
        String pald = "";
        for ( ; i >= 0; i--){
            if (str.charAt(i) == str.charAt(0) && check(str, 0, i)){
                pald = str.substring(0, i + 1);
                break;
            }
        }
        String left = str.substring(i + 1);
        StringBuilder input1 = new StringBuilder();

        // append a string into StringBuilder input1
        input1.append(left);

        // reverse StringBuilder input1
        input1 = input1.reverse();
        StringBuilder sb = new StringBuilder();
        sb.append(input1);
        sb.append(str);
        return new String(sb);
    }

    public boolean check(String s, int start, int end){
        while (start < end){
            if (s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else {
                return false;
            }
        }
        return true;
    }
}