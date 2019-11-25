public class Solution {
    /*
     * @param A: An integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> continuousSubarraySum(int[] A) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        res = Arrays.asList(0, 0);
        if (A == null || A.length == 1){
            return res;
        }
        //max记录全局最大值，sum记录区间和，如果当前sum>0，那么可以继续和后面的数求和，否则就从0开始
        int max = Integer.MIN_VALUE, preSum = 0, minSum = 0;
        int left = -1, right = 0;
        for (int i = 0; i < A.length; i++) {
            preSum += A[i];
            //max = Math.max(max, preSum - minSum);
            if (max < (preSum - minSum)){
                right = i;
                res.set(0, left + 1);
                res.set(1, right);
                max = preSum - minSum;
            }
            //minSum = Math.max(minSum, preSum);
            if (minSum > preSum) {
                left = i;
                minSum = preSum;
            }
        }

        return res;
    }
}