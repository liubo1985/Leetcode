package com.practice.allSubsets;

import java.util.ArrayList;

/**
 * Created by bliu on 11/2/15.
 * Write a method to return all subsets of a set
 */
public class GetSubsets {
   public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index)
   {
       ArrayList<ArrayList<Integer>> allSubsets;
       if(index == -1)
       {
           allSubsets = new ArrayList<ArrayList<Integer>>();
           allSubsets.add(new ArrayList<Integer>());
           //return allSubsets;
       }

       else
       {
           allSubsets = getSubsets(set, index - 1);
           int item = set.get(index);
           ArrayList<ArrayList<Integer>> newSubsets = new ArrayList<ArrayList<Integer>>();
           for(ArrayList<Integer> subset : allSubsets)
           {
               ArrayList<Integer> temp = new ArrayList<Integer>();
               temp.addAll(subset);
               temp.add(item);
               newSubsets.add(temp);
           }
           allSubsets.addAll(newSubsets);
       }
       return allSubsets;
   }

    public static void main(String[] args)
    {
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(new Integer(1));
        array.add(new Integer(2));
        array.add(new Integer(3));
        ArrayList<ArrayList<Integer>> allSubsets = getSubsets(array, array.size() - 1);
        for(ArrayList<Integer> subset : allSubsets)
        {
            System.out.print("Subset is: ");

            for(Integer singleset : subset)
            {

                System.out.print(singleset + ",");
            }
            System.out.println();
        }

    }
}
