package CC150.Subsets2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bliu on 5/12/16.
 */

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> results = new ArrayList();
        Arrays.sort(nums);
        helper(nums, 0, list, results);
        return results;
    }

    public void helper(int[] nums, int pos, List<Integer> list, List<List<Integer>> results){
        results.add(list);
        for(int i = pos; i < nums.length; i++){
            //skip duplicated element
            if(i != pos && nums[i] == nums[i - 1]){
                continue;
            }
            list.add(nums[i]);
            helper(nums, i + 1, new ArrayList<Integer>(list), results);
            list.remove(list.size() - 1);
        }
    }
}