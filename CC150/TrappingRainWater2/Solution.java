public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */

    class Element {
        int row;
        int col;
        int val;
        Element (int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    public int trapRainWater(int[][] heights) {
        // write your code here
        if (heights == null || heights.length == 0){
            return 0;
        }

        PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>(){
            public int compare(Element a, Element b){

                return a.val - b.val;
            }
        }
        );

        boolean[][] visited = new boolean[heights.length][heights[0].length];

        for (int i = 0; i < heights.length; i++){
            pq.offer(new Element(i, 0, heights[i][0]));
            pq.offer(new Element(i, heights[0].length - 1, heights[i][heights[0].length - 1]));
            visited[i][0] = true;
            visited[i][heights[0].length - 1] = true;
        }

        for (int i = 0; i < heights[0].length; i++){
            if (!visited[0][i]){
                pq.offer(new Element(0, i, heights[0][i]));
                visited[0][i] = true;
            }
            if (!visited[heights.length -1][i]){
                pq.offer(new Element(heights.length - 1, i, heights[heights.length - 1][i]));
                visited[heights.length - 1][i] = true;
            }
        }

        int res = 0;

        while (!pq.isEmpty()){
            Element cur = pq.poll();
            int row = cur.row;
            int col = cur.col;
            for (int i = 0; i < 4; i++){
                int nRow = row + dx[i];
                int nCol = col + dy[i];
                if (nRow < 0 || nRow >= heights.length || nCol < 0 || nCol >= heights[0].length || visited[nRow][nCol]){
                    continue;
                }
                // NOTE: Should use cur.val rather than heights[row][col], the reason is that we will update the height of
                // new Element, worthy of attention
                pq.offer(new Element(nRow, nCol, Math.max(heights[nRow][nCol], cur.val)));
                if (cur.val > heights[nRow][nCol]){
                    res += cur.val - heights[nRow][nCol];
                }
                visited[nRow][nCol] = true;

            }
        }
        return res;
    }
}