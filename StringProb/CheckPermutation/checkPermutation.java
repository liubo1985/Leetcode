package com.StringProb.CheckPermutation;

/**
 * Created by bliu on 2/15/16.
 *
 * Given two strings, write a method to decide if one is a permutation of the other.
 */
public class checkPermutation {

     public static boolean permutation(String str1, String str2){
         if(str1 == null || str2 == null || str1.length() != str2.length())
             return false;

         int[] letter = new int[256];

         for(int i = 0; i < str1.length(); i++){
             int cha = str1.charAt(i);
             ++letter[cha];
         }

         for(int i = 0; i < str2.length(); i++){
             int cha = str2.charAt(i);
             if(--letter[cha] < 0)
                 return false;
         }
         return true;
     }

     public static void main(String[] args){
         String str1 = "abcde";
         String str2 = "cdjab";

         System.out.println("String1 is permutation of string2 ? :" + permutation(str1, str2));
     }
}
