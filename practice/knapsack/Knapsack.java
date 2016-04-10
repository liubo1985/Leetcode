package com.practice.knapsack;

/**
 * Created by bliu on 2/2/16.
 */
public class Knapsack {

    public static int KnapsackValue(int[] val, int[] wt, int w, int n){

        if (n == 0 || w <= 0)
            return 0;

        if (wt[n - 1] > w)
            return KnapsackValue(val, wt, w, n -1);

        else
            return Math.max(val[n - 1] + KnapsackValue(val, wt, w - wt[n - 1], n - 1), KnapsackValue(val, wt, w, n -1));
    }


    public static int KnapsackValue2(int[] val, int[] wt, int W, int n)
    {
        int i, w;
        int[][] K = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i==0 || w==0)
                    K[i][w] = 0;
                else if (wt[i-1] <= w)
                    K[i][w] = Math.max(val[i-1] + K[i - 1][w-wt[i-1]],  K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }

        return K[n][W];
    }

    public static void main(String[] args){
        int[] val = new int[]{60, 100, 120};
        int[] wt = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;

        System.out.println("The most value is: " + KnapsackValue2(val, wt, W, n));


    }
}
