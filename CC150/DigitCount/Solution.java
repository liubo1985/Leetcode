public class Solution {
    /**
     * @param k: An integer
     * @param n: An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        if (k == n){
            return 1;
        }
        int count = 0;
        for (int i = 0; i <= n; i++){
            count += findDigit(k, i);
        }
        return count;
    }

    public int findDigit(int k, int i){
        if (k == 0 && i == 0){
            return 1;
        }
        int count = 0;
        while(i > 0){
            if (k == (i % 10)){
                count++;
            }
            i /= 10;
        }
        return count;
    }
}