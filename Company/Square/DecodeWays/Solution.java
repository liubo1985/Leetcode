public class Solution {
    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // write your code here
        if (s == null || s.length() == 0){
            return 0;
        }
        int[] ways = new int[s.length() + 1];
        //initialization
        //
        ways[0] = 1;
        ways[1] = s.charAt(0) - '0' >= 1 && s.charAt(0) - '0' <= 9 ? 1 : 0;
        for (int i = 2; i <= s.length(); i++){
            char cur = s.charAt(i - 1);
            // 如果只有1 - 9，那么只有一种decode方式
            if (cur - '0' > 0 && cur - '0' <= 9){
                ways[i] = ways[i - 1];
            }
            //如果当前位和前一位能够组成10 - 26的数，那么要加上前两位的decode种类
            int num = (s.charAt(i - 2) - '0') * 10 + cur - '0';
            if (num >= 10 && num <= 26){
                ways[i] += ways[i - 2];
            }
        }
        return ways[s.length()];
    }
}