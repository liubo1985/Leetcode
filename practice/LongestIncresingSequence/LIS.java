package com.practice.LongestIncresingSequence;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

/**
 * Created by bliu on 1/12/16.
 */
public class LIS {
    public static int increasingSubsequence(int[] seq){
        int[] lis = new int[seq.length];
        lis[0] = 1;
        int maxLong = 0;

        for(int i = 1; i < seq.length; i++){
            int maxn = 0;

            for(int j = 0; j < i; j++){
                if(seq[i] > seq[j] && lis[j] > maxn)
                    maxn = lis[j];
            }

            lis[i] = maxn + 1;
        }

        for(int i = 0; i < lis.length; i++){
            if(maxLong < lis[i])
                maxLong = lis[i];
        }

        return maxLong;


    }


}
