public class Solution {
    /**
     * @param stones: a list of stones' positions in sorted ascending order
     * @return: true if the frog is able to cross the river or false
     */
    public boolean canCross(int[] stones) {
        // write your code here
        if (stones == null || stones.length == 0){
            return false;
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < stones.length; i++){
            map.put(stones[i], new HashSet<>());
        }
        map.get(stones[0]).add(0);

        for (int i = 0; i < stones.length - 1; i++){
            HashSet<Integer> set = new HashSet<Integer>(map.get(stones[i]));
            for (int ele : set){
                // next jump must be either k - 1, k or k + 1
                for (int j = -1; j <= 1; j++){
                    int step = ele + j;
                    if (map.containsKey(stones[i] + step)){
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return !map.get(stones[stones.length - 1]).isEmpty();
    }
}