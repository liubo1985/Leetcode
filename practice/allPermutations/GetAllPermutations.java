package com.practice.allPermutations;

import java.util.ArrayList;

/**
 * Created by bliu on 11/3/15.
 * Write a method to compute all permutations of a string
 */
public class GetAllPermutations {

    public static ArrayList<String>  getAllPermutation(String str, int index)
    {
        if(str == null)
        {
            return null;
            //return;
        }

        ArrayList<String> allPermutations = new ArrayList<String>();;
        if (index < 0)
        {

            allPermutations.add("");
            //return allPermutations;
            return allPermutations;
        }

        ArrayList<String> previousPerm = getAllPermutation(str, index -1);
        //getAllPermutation(str, allPermutations, index -1);
        char cha = str.charAt(index);

        for(String word : previousPerm)
        //for(String word : allPermutations)
        {
            for(int i = 0; i <= word.length(); i++)

            {
                String newString = insertChar(word, cha, i);
                allPermutations.add(newString);
            }

        }
        return allPermutations;


    }

    public static String insertChar(String word, char cha, int index)
    {
        String start = word.substring(0, index);
        String end = word.substring(index);
        return start + cha + end;

    }

    public static void main(String[] args)
    {
        String str = "come";
        //ArrayList<String> allPermutations = new ArrayList<String>();
        ArrayList<String> permutations = getAllPermutation(str, str.length() - 1);
        getAllPermutation(str, str.length() - 1);
        System.out.println("The permutations are: " );
        for(String word : permutations)
        {
            System.out.println(word);
        }
        System.out.println("end !");
    }
}
