package CC150.MaximumDepthofBinaryTree;


class Solution {
    public int twoCitySchedCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int res = 0;
        int total = costs.length;
        for (int i = 0; i < costs.length; i++){
            res += costs[i][0];
        }
        Arrays.sort(costs, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1] - a[0] - (b[1] - b[0]);
            }
        });
        int countB = 0;
        for (int[] cost : costs){
            if (countB < total/2){
                res += cost[1] - cost[0];
                countB++;
            }
        }
        return res;
    }
}