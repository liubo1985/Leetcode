package com.CC150.SwapNodesinPairs;

/**
 * Created by bliu on 3/17/16.
 */
/**
 * Leetcode 1031
 *
 */
class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        if (A == null || A.length == 0){
            return 0;
        }
        int currentSum = 0;
        int[] preSum = new int[A.length + 1];
        preSum[0] = 0;
        for (int i = 1; i <= A.length; i++){
            preSum[i] = preSum[i - 1] + A[i - 1];
        }

        int[] leftMaxL = new int[A.length + 1];
        int[] leftMaxM = new int[A.length + 1];
        int[] rightMaxL = new int[A.length + 1];
        int[] rightMaxM = new int[A.length + 1];
        int res = Integer.MIN_VALUE;

        int maxL = 0;
        int maxM = 0;
        int maxRightL = 0;
        int maxRightM = 0;
        //scan left
        for (int i = 0; i <= A.length; i++){
            if (i >= L){
                maxL = Math.max(maxL, preSum[i] - preSum[i - L]);
                leftMaxL[i] = maxL;
            }
            if (i >= M){
                maxM = Math.max(maxM, preSum[i] - preSum[i - M]);
                leftMaxM[i] = maxM;
            }

            if (A.length - i + L <= A.length){
                maxRightL = Math.max(maxRightL, preSum[A.length - i + L] - preSum[A.length - i]);
                rightMaxL[A.length - i] = maxRightL;
            }
            if (A.length - i + M <= A.length){
                maxRightM = Math.max(maxRightM, preSum[A.length - i + M] - preSum[A.length - i]);
                rightMaxM[A.length - i] = maxRightM;
            }
        }

        //find the max sum from left + right
        for(int i = 0; i <= A.length; i++){
            res = Math.max(res, Math.max(leftMaxL[i] + rightMaxM[i], leftMaxM[i] + rightMaxL[i]));

        }
        return res;
    }
}