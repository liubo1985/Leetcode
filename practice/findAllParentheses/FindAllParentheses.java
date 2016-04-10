package com.practice.findAllParentheses;

import java.util.ArrayList;

/**
 * Created by bliu on 11/4/15.
 * implement an algorithm to print all valid (i.e. properly opened and closed) combinations of n-pairs of parentheses.
 */
public class FindAllParentheses {


    public static void findAllParenthese(String list, ArrayList<String> Permutation,  int leftParen, int rightParen)
    {

        if(leftParen < 0 || rightParen < leftParen)
        {
            return;
        }
        //base case
        if((leftParen == 0) && (rightParen == 0))
        {
            Permutation.add(list);

            return;
        }else
        {

            if(leftParen > 0)
            {
                //list.add("(");

                findAllParenthese(list + "(", Permutation, leftParen - 1, rightParen);

            }


            if(rightParen > leftParen)
            {
                //list.add(")");
                findAllParenthese(list + ")", Permutation, leftParen, rightParen - 1);


            }
        }
    }

    public static void main (String[] args)
    {

        ArrayList<String> permutations = new ArrayList<String>();
        findAllParenthese("", permutations, 2, 2);
        //print
        for(String list : permutations)
        {
            System.out.println();
            for(char str : list.toCharArray())
            {
                System.out.print(str + " ");
            }
        }
    }
}
