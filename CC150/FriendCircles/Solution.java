public class Solution {
    /**
     * @param M: a matrix
     * @return: the total number of friend circles among all the students
     */
    public int findCircleNum(int[][] M) {
        // Write your code here
        if (M == null || M.length == 0){
            return 0;
        }
        int res = 0;
        for (int i = 0; i < M.length; i++){
            if (M[i][i] == 1){
                res++;
                bfs(M, i);
            }
        }
        return res;
    }

    private void bfs(int[][] M, int i){
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        while (!q.isEmpty()){
            int cur = q.poll();
            M[cur][cur] = 2;
            for (int j = 0; j < M[0].length; j++){
                if (M[cur][j] == 1 && M[j][j] == 1){
                    q.offer(j);
                }
            }
        }
    }
}