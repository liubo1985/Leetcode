package com.CC150.Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bliu on 4/6/16.
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        int index = nums.length - 1;
        List<List<Integer>> permutation;
        permutation = helper(nums, index);
        return permutation;
    }

    public List<List<Integer>> helper(int[] nums, int index){
        List<List<Integer>> permutation = new ArrayList();

        if(index == 0){
            //list.add(nums[0]);
            permutation.add(new ArrayList<Integer>(nums[0]));
            return permutation;
        }

        List<List<Integer>> prePermutation = helper(nums, index - 1);
        int num = nums[index];

        for(List<Integer> member : prePermutation){
            List<Integer> list = member;
            for(int i = 0; i <= member.size(); i++){

                if(i != member.size()){
                    list.add(i, num);
                }
                else{
                    list.add(num);
                }

                //if(member.size() == nums.length){
                permutation.add(list);
                //}
            }
        }
        return permutation;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{0,1};
        Solution solution = new Solution();
        //ArrayList<String> allPermutations = new ArrayList<String>();
        List<List<Integer>> permutations = solution.permute(nums);


    }
}

