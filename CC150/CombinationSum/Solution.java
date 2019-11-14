
public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> combinations = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return combinations;
        }
        Arrays.sort(candidates);
        helper(candidates, target, combination, combinations, 0);
        return combinations;
    }

    private void helper(int[] candidates, int target, List<Integer> list, List<List<Integer>> combinations, int pos){

        if (target == 0){
            combinations.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = pos; i < candidates.length; i++){
            if (i != 0 && candidates[i] == candidates[i - 1]){
                continue;
            }
            if (candidates[i] > target){
                continue;
            }
            list.add(candidates[i]);
            helper(candidates, target - candidates[i], list, combinations, i);
            list.remove(list.size() - 1);
        }
    }
}