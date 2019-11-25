class Point{
    int time;
    int flag;

    Point(int t, int s){
        this.time = t;
        this.flag = s;
    }
    public static Comparator<Point> PointComparator  = new Comparator<Point>(){
        public int compare(Point p1, Point p2){
            if(p1.time == p2.time) return p1.flag - p2.flag;
            else return p1.time - p2.time;
        }
    };
}
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        List<Point> list = new ArrayList<>(intervals.length*2);
        for(Interval i : intervals){
            list.add(new Point(i.start, 1));
            list.add(new Point(i.end, 0));
        }

        Collections.sort(list,Point.PointComparator );
        int count = 0, ans = 0;
        for(Point p : list){
            if(p.flag == 1) {
                count++;
            }
            else {
                count--;
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }
}