package com.SearchAndSort.binarySearch;

/**
 * Created by bliu on 11/25/15.
 */
public class BinarySearch {
    public static int binarySearch(int[] array, int start, int end, int des)
    {
        if(start > end)
            return 0;
        int mid =(start + end) / 2;


        while(start < end - 1)
        {
            mid = (start + end) / 2;
            if(array[mid] > des)
            {
                end = mid;
            }
            else if (array[mid] < des)
            {
                start = mid;
            }
            else
                return mid;


        }
        return mid;
    }

    public static void main(String[] args)
    {
        int[] i = new int[]{1,3,5,7,9,11,13,16,22,35};
        int index = binarySearch(i, 0, i.length - 1, 6);
        System.out.println("Index is:" + index);
    }

}
