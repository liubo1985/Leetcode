package com.practice.runningStairCase;


/**
 * Created by bliu on 10/22/15.
 */
public class RunningStaircase {
    public static void main(String[] args)
    {
        int n = runningStaircase(3);
        System.out.println("Total ways to running up a staircase is: " + n);
    }

    public static int runningStaircase(int n)
    {
        if (n < 0)
            return 0;
        else if (n == 0)
            return 1;
        else {
            return runningStaircase(n - 1) + runningStaircase(n - 2) + runningStaircase(n - 3);
        }
    }
}
