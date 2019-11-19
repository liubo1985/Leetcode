public class Solution {
    /**
     * @param n: An integer
     * @param m: An integer
     * @param i: A bit position
     * @param j: A bit position
     * @return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        int allOnes = ~0;
        int partOnes = j == 31 ? allOnes : (1 << (j + 1)) - 1;
        int left = allOnes - partOnes;
        int right = (1 << i) - 1;
        return ((left | right) & n) | (m << i);
    }
}