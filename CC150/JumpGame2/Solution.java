package com.CC150.JumpGame2;

/**
 * Created by bliu on 4/10/16.
 * 解题报告：基本思路就是求出每个元素可能跳到的最大坐标，然后串行统计一共需要多少次可以跳到末尾。
 以上面的输入为例，生成的每个元素可能跳到的最大坐标的数组为：2,4,4,4,8，统计跳的次数为：从0-2-4，一共需要跳2次。
 虽然用到了2次循环，但最多遍历一次数组中的元素，所以时间复杂度为：O(n)
 */

//Greedy algorithm, maintain an interval, every time find max reach in that interval, then upgrade start and end
// of interval
public class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0 ||nums.length == 1)
            return 0;
        int start = 0;
        int end = 0;
        int max = 0;
        int steps = 0;
        while(end < nums.length){
            max = 0;
            steps++;
            for(int i = start; i <= end; i++){
                if(i + nums[i] >= nums.length - 1){
                    return steps;
                }
                if(i + nums[i] > max){
                    max = i + nums[i];

                }
            }
            start = end + 1;
            end = max;
        }
        return steps;
    }
}

