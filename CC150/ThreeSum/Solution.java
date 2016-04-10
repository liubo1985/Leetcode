package com.CC150.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bliu on 3/14/16.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3 && nums == null){
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> all_threeSum = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 2; i++){

            if (i != 0 && nums[i] == nums[i - 1]) {
                continue; // to skip duplicate numbers; e.g [0,0,0,0]
            }
            int start = i + 1;
            int end = nums.length - 1;

            while(start < end){
                if(nums[i] + nums[start] + nums[end] == 0){
                    List<Integer> threeSum = new ArrayList<Integer>();
                    threeSum.add(nums[i]);
                    threeSum.add(nums[start]);
                    threeSum.add(nums[end]);
                    all_threeSum.add(threeSum);
                    start++;
                    end--;

                    while (start < end && nums[start] == nums[start - 1]) { // to skip duplicates
                        start++;
                    }
                    while (start < end && nums[end] == nums[end + 1]) { // to skip duplicates
                        end--;
                    }
                }
                else if(nums[i] + nums[start] +nums[end] > 0){
                    end--;
                }
                else{
                    start++;
                }
            }
        }
        return all_threeSum;
    }
}