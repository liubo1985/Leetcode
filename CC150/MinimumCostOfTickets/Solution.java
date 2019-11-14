package CC150.MaximumDepthofBinaryTree;

/**
 * In a country popular for train travel, you have planned some train travelling one year in advance.
 * The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.

 Train tickets are sold in 3 different ways:

 a 1-day pass is sold for costs[0] dollars;
 a 7-day pass is sold for costs[1] dollars;
 a 30-day pass is sold for costs[2] dollars.
 The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2,
 then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.

 Return the minimum number of dollars you need to travel every day in the given list of days.
 */


class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if(days == null || days.length == 0){
            return 0;
        }
        int[] spend = new int[366];
        int[] plan  = new int[366];
        spend[0] = 0;
        plan[0] = 0;

        for (int i = 0; i < days.length; i++){
            plan[days[i]] = 1;
        }

        for (int i = 1; i < 366; i++){
            if (plan[i] == 0){
                spend[i] = spend[i - 1];
            }else {
                spend[i] = Math.min(spend[i - 1] + costs[0], Math.min(spend[Math.max(i - 7, 0)] + costs[1], spend[Math.max(i - 30, 0)] + costs[2]));
            }
        }
        return spend[365];
    }
}