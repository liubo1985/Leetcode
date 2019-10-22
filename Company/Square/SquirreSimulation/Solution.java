public class Solution {
    /**
     * @param height: the height
     * @param width: the width
     * @param tree: the position of tree
     * @param squirrel: the position of squirrel
     * @param nuts: the position of nuts
     * @return: the minimal distance
     */
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {

        if (height == 0 || width == 0){
            return 0;
        }
        int res = 0, n2t = Integer.MIN_VALUE;
        for (int i = 0; i < nuts.length; i++){
            int distanceN2T = Math.abs(tree[0] - nuts[i][0]) + Math.abs(tree[1] - nuts[i][1]);
            res += distanceN2T * 2;
            n2t = Math.max(n2t, distanceN2T - (Math.abs(squirrel[0] - nuts[i][0]) + Math.abs(squirrel[1] - nuts[i][1])));
        }
        return res - n2t;
    }


}