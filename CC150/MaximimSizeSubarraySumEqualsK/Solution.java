public class Solution {
    /**
     * @param nums: an array
     * @param k: a target value
     * @return: the maximum length of a subarray that sums to k
     */
    public int maxSubArrayLen(int[] nums, int k) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] preSum = new int[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(k, 0); // in case preSum[i]= k, precess it specially
        int res = 0;
        for (int i = 1; i <= nums.length; i++){
            preSum[i] = preSum[i - 1] + nums[i - 1];
            if (map.containsKey(preSum[i])){
                res = Math.max(res, i - map.get(preSum[i]));
            }
            if (!map.containsKey(preSum[i] + k)){
                map.put(preSum[i] + k, i);
            }
        }
        return res;
    }
}