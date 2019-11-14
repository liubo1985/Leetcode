public class Solution {
    /**
     * @param positions: a list of (left, side_length)
     * @return: return a list of integer
     */
    public List<Integer> fallingSquares(int[][] positions) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (positions == null || positions.length == 0){
            return res;
        }
        int[] hight = new int[positions.length];
        for (int i = 0; i < positions.length; i++){
            hight[i] += positions[i][1];
            int start = positions[i][0];
            int end   = start + positions[i][1];
            for (int j = i + 1; j < positions.length; j++){
                int left = positions[j][0];
                int right= left + positions[j][1];
                if (right > start && end > left){
                    hight[j] = Math.max(hight[j], hight[i]);
                }
            }
        }
        int max = 0;
        for (int cur : hight){
            max = Math.max(max, cur);
            res.add(max);
        }
        return res;
    }
}