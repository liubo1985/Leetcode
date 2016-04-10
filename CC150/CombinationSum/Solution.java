package com.CC150.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bliu on 4/1/16.
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(candidates);
        int start = 0;
        processSum(candidates, target, start, list, result);

        return result;

    }

    private void processSum(int[] candidates, int sum, int start, List<Integer> list, List<List<Integer>> result){
        for(int i = start; i < candidates.length; i++){
            List<Integer> tempList = new ArrayList<Integer>(list);
            tempList.add(candidates[i]);
            int remain = sum - candidates[i];

            if(remain < 0){
                break;
            }

            //base case
            if(remain == 0){
                result.add(tempList);
                break;
            }
            else{
                processSum(candidates, remain, i, new ArrayList<Integer>(tempList), result);
            }
        }
    }

    public static void main(String[] args){
        int[] array = new int[]{1,2, 5, 10};
        int target = 20;
        Solution solution = new Solution();
        List<List<Integer>> result = solution.combinationSum(array, target);
    }
}
