package CC150.InsertInterval;

/**
 * Created by bliu on 4/12/16.
 * 思路：先插入，在合并重叠区间。既然是已经排好序的，就可以用二分查找的方法，把要插入的这个区间放到应该的位置。
 * 合并重叠区间的方法《【LeetCode】Merge Intervals 解题报告》一样。
 */

import java.util.ArrayList;
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

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals.size() == 0 || intervals == null){
            res.add(newInterval);
            return res;
        }
        if(newInterval == null){
            return intervals;
        }
        int start = 0;
        int end = intervals.size() - 1;
        //int mid = start + (end - start)/2;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(intervals.get(mid).start == newInterval.start){
                //intervals.add(mid, newInterval);
                start = mid;
                break;
            }
            else if(intervals.get(mid).start > newInterval.start){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        intervals.add(start, newInterval);

        start = intervals.get(0).start;
        end = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++){
            Interval cur = intervals.get(i);
            if(cur.start <= end){
                end = Math.max(end, cur.end);
            }
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