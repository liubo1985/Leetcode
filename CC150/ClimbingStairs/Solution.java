package CC150.ClimbingStairs;

/**
 * Created by bliu on 4/20/16.
 */


public class Solution {
    public int[] cache;
    public int climbStairs(int n) {
        cache = new int[n];
        int res = helper(n);
        return res;

    }

    public int helper(int n){
        if(n == 1){
            cache[0] = 1;
            return 1;
        }
        if(n == 2){
            cache[1] = 2;
            return 2;
        }
        return updateCache(n - 1) + updateCache(n - 2);
    }

    public int updateCache(int n){

        if(cache[n-1] > 0){
            return cache[n-1];
        }
        else{
            cache[n-1] = helper(n);
        }
        return cache[n-1];
    }
}