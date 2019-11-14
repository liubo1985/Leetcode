


public class Solution {
    /**
     * @param n: the integer to be reversed
     * @return: the reversed integer
     */
    public int reverseInteger(int n) {
        // write your code here
        long res = 0L;

        while (n != 0){
            res = res * 10 + n % 10;
            if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE){
                return 0;
            }
            n /= 10;
        }
        return (int)res;
    }
}