package com.CC150.ContainerWithMostWater;

/**
 * Created by bliu on 3/16/16.
 *
 * 正确性证明：由于水的容量是有较小的那个边界决定的，因此某次迭代中，假设height[i] < height[j]，那么j 减小肯定不会使水的容量增大，
 * 只有i 增加才有可能使水的容量增大。但是会不会有这种可能：当前的i 和 某个k (k > j)是最大容量, 这也是不可能的，因为按照我们的移动规则，
 * 既然右指针从k 移动到了j，说明i 的左边一定存在一个边界 m，使m > k，那么[m, k]的容量肯定大于[i, k]，所以[i,k]不可能是最大容量。
 */
public class Solution1 {
    public int maxArea(int[] height) {
        int max = 0;
        int start = 0, end = height.length - 1;

        while(start < end){
            max = Math.max(max, (end - start)*Math.min(height[start], height[end]));
            if(height[start] >= height[end]){
                end--;
            }
            else{
                start++;
            }

        }
        return max;
    }
}