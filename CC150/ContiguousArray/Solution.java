public class Solution {
    /**
     * @param nums: a binary array
     * @return: the maximum length of a contiguous subarray
     */
    public int findMaxLength_1(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;

        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int res = Integer.MIN_VALUE;
        int subSum = 0;
        for (int len = 1; len <= nums.length; len++) {
            for (int i = 0; i + len <= nums.length; i++) {
                subSum = preSum[i + len] - preSum[i];
                if (len % 2 == 0 && subSum == (len / 2)) {
                    if (res < len) {
                        res = len;
                    }
                }
            }
        }
        return res;
    }

    public int findMaxLength(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> sum = new HashMap<>();
        sum.put(0, -1);
        int res = Integer.MIN_VALUE;
        int preSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                preSum++;
            } else {
                preSum--;
            }

            if (sum.containsKey(preSum)){
                res = Math.max(res, i - sum.get(preSum));
            } else {
                sum.put(preSum, i);
            }
        }
        return res;
    }
}