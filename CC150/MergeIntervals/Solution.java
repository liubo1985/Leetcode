package CC150.MergeIntervals;

/**
 * Created by bliu on 4/11/16.
 * 思路：先排序，然后检查相邻两个区间，看前一个区间的结尾是否大于后一个区间的开始，注意前一个区间包含后一个区间的情况。
 */

import sun.jvm.hotspot.utilities.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {

    public class Interval {
            int start;
            int end;
            Interval() { start = 0; end = 0; }
            Interval(int s, int e) { start = s; end = e; }
    }

    public class MyComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b){
            return a.start - b.start;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0 || intervals == null)
            return new ArrayList<Interval>();
        MyComparator myComparator = new MyComparator();
        List<Interval> copy = new ArrayList<Interval>(intervals);
        List<Interval> res = new ArrayList<Interval>();
        Collections.sort(copy, myComparator);
        int start = copy.get(0).start;
        int end = copy.get(0).end;

        for(int i = 1; i < copy.size(); i++){
            Interval cur = copy.get(i);
            //if prev interval's end is greater than cur's start, turns out overlopped. update end
            if(end >= cur.start){

                end = Math.max(cur.end, end);
            }
            // else turns out no overlap, add pre interval, then update start, end
            else {
                res.add(new Interval(start, end));
                start = cur.start;
                end = cur.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}
