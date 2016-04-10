package com.CC150.TrappingRainWater;

/**
 * Created by bliu on 4/6/16.
 */

public class Solution2 {
    public int trap(int[] height) {
        if(height.length == 0 || height == null)
            return 0;
        int start = 0;
        int end = height.length - 1;
        int smaller = 0;
        int sum = 0;

        while(start < end){
            //只要右边的柱子有比左边的高，比smaller小的柱子都能盛水，只需找到比smaller大的柱子即可停止
            if(height[start] < height[end]){
                smaller = height[start];
                while(start < end && smaller >= height[start]){
                    sum += smaller - height[start];
                    start++;
                }
            }
            else{
                //只要左边的柱子有比右边的高，比smaller小的柱子都能盛水，只需找到比smaller大的柱子即可停止
                smaller = height[end];
                while(start < end && smaller >= height[end]){
                    sum += smaller - height[end];
                    end--;
                }
            }
        }
        return sum;
    }
}