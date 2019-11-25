class Solution {
      public int[][] kClosest(int[][] points, int K) {
                 if(points == null || points.length == 0 || K < 1){
                         return points;
                    }

                PriorityQueue<int []> pq = new PriorityQueue<int []>((a, b) -> getDistanceSquare(b)-getDistanceSquare(a));
                 for(int [] point : points){
                         pq.add(point);
                         if(pq.size() > K){
                                 pq.poll();
                             }
                     }

                 int [][] res = new int[K][2];
                for(int i = 0; i<K; i++){
                         res[i] = pq.poll();
                     }

                 return res;
             }

             private int getDistanceSquare(int [] point){
                return point[0]*point[0] + point[1]*point[1];
             }
 }