

6 months ago
        Accepted
        String to Integer (atoi)
        252 ms

        Java

        6 months ago
        Accepted
        String to Integer (atoi)
        201 ms

        Java

        6 months ago
        Wrong Answer
        String to Integer (atoi)
        201 ms

        Java

        6 months ago
        Accepted
        String to Integer (atoi)
        201 ms

        Java

        6 months ago
        Accepted
        String to Integer (atoi)
        201 ms

        Java

        6 months ago
        Wrong Answer
        String to Integer (atoi)
        186 ms

        Java

        6 months ago
        Wrong Answer
        String to Integer (atoi)
        201 ms

        Java

        6 months ago
        Wrong Answer
        String to Integer (atoi)
        201 ms

        Java

        6 months ago
        Wrong Answer
        String to Integer (atoi)
        229 ms

        Java

        Load More...
        54. String to Integer (atoi)
        中文
        English

        Implement function atoi to convert a string to an integer.

        If no valid conversion could be performed, a zero value is returned.

        If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
        Example

        Example 1

        Input: "10"
        Output: 10

        Example 2

        Input: "1"
        Output: 1

        Example 3

        Input: "123123123123123"
        Output: 2147483647
        Explanation: 123123123123123 > INT_MAX, so we return INT_MAX

        Example 4

        Input: "1.0"
        Output: 1
        Explanation: We just need to change the first vaild number

        "10"
        sentinelStart
        Hard
        String to Integer (atoi) - Java
        Accepted
        100%  test cases passed
        Total runtime: 202ms
        Wrong code got passed?
        Provide more test data to LintCode!
        Runtime (ms)Distribution (%)
        Your submission beats 37.80% SubmissionsYour submission beats 37.80% Submissions50010001500200001224364860
        Zoom area by dragging across this chart
        500100015002000
        Code(Language:Java) (Judger:ip-172-31-5-19)

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