package com.CC150.LongestPanlindromeString;

/**
 * Created by bliu on 3/13/16.
 */
class Solution {

    public String longestPalindrome(String s) {
        int n = s.length();

        if (n <= 1)
            return s;

        int maxlen = 1, k, j, a = 0;
        int l;

        for (int i = 1; i < n;) {
            k = i - 1;
            j = i + 1;

            while (k >= 0 && s.charAt(k) == s.charAt(i))
                 k--;

            while (j < n && s.charAt(j) == s.charAt(i))
                 j++;

            i = j;//这个地方i=j 为了防止 s[i]出现多次，后面的一些判断就是多余。例如 baaaabc, 当i=1,此时 j=5

            //从k和j开始向两边扩展
            while (k >= 0 && j < n && s.charAt(k) == s.charAt(j)) {

                k--;
                j++;

            }

            l = j - k - 1;

            if (maxlen < l) {

                a = k + 1;

                maxlen = l;

            }

        }

        return s.substring(a, maxlen);

    }

};
