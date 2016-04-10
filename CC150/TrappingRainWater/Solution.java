package com.CC150.TrappingRainWater;

/**
 * Created by bliu on 4/5/16.
 */

public class Solution {
    public int trap(int[] height) {
        if(height.length < 3)
            return 0;
        int l = 0;
        int r = height.length;
        int[] left_max = new int[r];
        int[] right_max = new int[r];

        for(int i = 1; i < r; i++){
            left_max[i] = Math.max(left_max[i - 1], height[i - 1]);
            right_max[r - 1 - i] = Math.max(right_max[r - i], height[r - i]);
        }

        int sum = 0;
        for(int i = 0; i < r; i++){
            int high = Math.min(left_max[i], right_max[i]);
            if(high > height[i]){
                sum += high - height[i];
            }
        }
        return sum;
    }
}
