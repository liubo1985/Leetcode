

public class Solution {
    /**
     * @param str: A string
     * @return: An integer
     */
    public int atoi(String str) {
        // write your code here
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();

        int sign = 1;
        int i = 0;
        if (str.charAt(0) == '+') {
            sign = 1;
            i++;
        } else if (str.charAt(0) == '-') {
            sign = -1;
            i++;
        }

        long res = 0;
        for (; i < str.length(); i++) {
            char cur = str.charAt(i);

            int digit = cur - '0';

            if (digit > 9 || digit < 0) {
                break;
            }
            res = res * 10 + digit;
            if (res > Integer.MAX_VALUE) {
                break;
            }
        }
        if (sign == 1 && (sign * res) > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (sign == -1 && (sign * res) < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)(sign * res);
    }
}