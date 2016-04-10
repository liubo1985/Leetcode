package com.String.palindrome.StringParse;

import java.util.Hashtable;

/**
 * Created by bliu on 1/30/16.
 */
public class stringParse {

    public static Hashtable dictionary;
    private String sentence;

    public stringParse (String sentence){
        this.sentence = sentence;
    }

    public int parseSimple (int wordStart, int wordEnd){

        if (wordEnd >= sentence.length()){
            return wordEnd - wordStart;
        }

        String word = sentence.substring(wordStart, wordEnd +1);
        System.out.println("split word is: " + word);

        int bestExact = parseSimple(wordEnd + 1, wordEnd + 1);

        if (!dictionary.containsKey(word)){
            bestExact += word.length();

        }

        System.out.println("Number of invalid words is: " + bestExact);

        int bestExtend = parseSimple(wordStart, wordEnd + 1);

        return Math.min(bestExact, bestExtend);
    }

    public static void  main(String[] arg){

        dictionary = new Hashtable();

        dictionary.put("i", 1);
        dictionary.put("it", 1);
        dictionary.put("hit", 1);
        dictionary.put("hi", 1);
        dictionary.put("this", 1);

        stringParse sp = new stringParse("thit");
        sp.parseSimple(0, 0);

    }
}
