package com.practice.magicIndex;

/**
 * Created by bliu on 10/30/15.
 * A magic index in an array A[1...n-1] is defined to be an index such that A[i] = i. Given a sorted array of
 * distinct integers, write a method to find a magic index, if one exists, in array A.
 * FOLLOW UP
 * What if the values are not distinct
 */
public class MagicIndexFinder {

    public static int getMagicIndex(int[] a, int start, int end){
        if(start < 0 || end >= a.length || end < start)
        {
            return -1;
        }

        int mid = (start + end)/2;
        if (a[mid] == mid){
            System.out.println("Magic index is:" + mid + ", value is: " + a[mid]);
            //return mid;
        }

        int i = getMagicIndex(a, start, Math.min(mid-1, a[mid]));
        if(i > 0)
            return i;

        return getMagicIndex(a, Math.max(mid + 1, a[mid]), end);

    }

    public static void main(String[] args)
    {
        int[] a = new int[]{-10, -5, -1, 1, 2, 3, 5, 7, 8, 9, 13};
        getMagicIndex(a, 0, a.length - 1);
    }
}
