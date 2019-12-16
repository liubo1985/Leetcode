public class Solution {
    /**
     * @param points: a 2D array
     * @return: the number of boomerangs
     */
    public int numberOfBoomerangs(int[][] points) {
        // Write your code here
        if (points == null || points.length == 0){
            return 0;
        }
        Point[] arr = new Point[points.length];
        int res = 0;
        for (int i = 0; i < points.length; i++){
            Map<Integer, List<int[]>> map = new HashMap<>();

            for (int j = 0; j < points.length; j++){
                if (i == j){
                    continue;
                }
                int distance = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                if (map.containsKey(distance)){
                    List<int[]> list = map.get(distance);
                    res += list.size();
                    list.add(points[j]);
                    map.put(distance, list);
                } else {
                    List<int[]> list = new ArrayList<>();
                    list.add(points[j]);
                    map.put(distance, list);
                }
            }
        }
        return res * 2;
    }
}