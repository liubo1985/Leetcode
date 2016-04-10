package com.practice.MakeChage;

/**
 * Created by bliu on 11/10/15.
 * Gievn an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cents),
 * write code to calculate the number of ways of representing n cents.
 */


public class MakeChage {

    public static void makeChange(String tsoln, int startIndex, int remainTarget, CoinChangeAnswer answer)
    {
        for(int i = startIndex; i < answer.denoms.length; i++)
        {
            int temp = remainTarget - answer.denoms[i];
            String temp_tsoln = tsoln + answer.denoms[i] + ",";
            if(temp < 0)
                break;

            if (temp == 0)
            {
                answer.answer.add(temp_tsoln);
                break;

            }
            else
            {
                makeChange(temp_tsoln, i, temp, answer);
            }
        }
    }

    public static void main(String[] args)
    {
        String tsoln = new String();
        int startIndex = 0;
        int target = 10;
        CoinChangeAnswer answer = new CoinChangeAnswer();
        answer.denoms = new int[]{1,2,5};
        makeChange(tsoln, startIndex, target, answer);

        System.out.println("Solution is: ");
        for(String str : answer.answer)
        {
            System.out.println(str);
        }


    }
}

