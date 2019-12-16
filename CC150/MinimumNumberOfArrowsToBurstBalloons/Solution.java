public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, new IntervalComparator());
        int ans = 1;
        int lastEnd = points[0][1];
        for(int i = 1; i < points.length; i++) {
            if (points[i][0] > lastEnd) {
                ans++;
                lastEnd = points[i][1];
            }
        }
        return ans;
    }

    class IntervalComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    }
}