package CC150.SearchinRotatedSortedArray2；

/**
 * Created by bliu on 4/26/16.
 */

// it ends up the same as sequential search
// We used linear search for this question just to indicate that the
// time complexity of this question is O(n) regardless of binary search is applied or not.
public class Solution {
    public boolean search(int[] A, int target) {
        for (int i = 0; i < A.length; i ++) {
            if (A[i] == target) {
                return true;
            }
        }
        return false;
    }
}
