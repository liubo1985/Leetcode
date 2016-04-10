package com.String.palindrome;

/**
 * Created by bliu on 11/11/15.
 */
public class IsPalindrome {

    public static boolean isPalindrome(String str)
    {
        if (str == null)
            return false;
        else
        {
            char[] cha = str.toCharArray();
            int length = str.length();
            for(int i = 0; i < str.length()/2; i++ )
            {
                if(Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(length - i - 1)))
                    return false;

            }
            return true;
        }

    }

    public static void main(String[] args)
    {
        String str = "a2cjedc2A";
        System.out.println(isPalindrome(str));
    }
}
