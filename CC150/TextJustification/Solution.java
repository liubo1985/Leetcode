package CC150.TextJustification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bliu on 4/19/2016.
 */

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        if(words == null || maxWidth == 0){
            return new ArrayList<String>();
        }
        List<String> res = new ArrayList<String>();
        int i = 0;
        int len = words.length;
        while(i < len){
            int j = i + 1;
            int size = 0;
            size += words[i].length();
            while(j < len && (size + 1 + words[j].length()) <= maxWidth){
                size += 1 + words[j].length();
                j++;
            }
            StringBuilder line = new StringBuilder();
            //if last line
            if(j == len){
                for(int k = i + 1; k < j; k++){
                    line.append(" ");
                    line.append(words[k]);
                }
                while(line.length() < maxWidth){
                    line.append(" ");
                }
            }
            else{
                //only one word in that line
                if(j == i + 1){
                    while(line.length() < maxWidth){
                        line.append(" ");
                    }
                }
                else{
                    //normal line
                    int numSpace = j - 1 - i;
                    int wordSize = size - numSpace;
                    int extraSpace = maxWidth - wordSize;
                    int count = 1;
                    for(int k = i + 1; k < j; k++){
                        for(int q = 0; q < extraSpace/numSpace; q++){
                            line.append(" ");

                        }
                        if(count < extraSpace % numSpace){
                            line.append(" ");
                            count++;
                        }
                        line.append(words[k]);
                    }
                }

            }
            res.add(line.toString());
            i = j;
        }
        return res;
    }

    public static void main(String[] args){
        String[] words = {""};
        int L = 0;
        Solution solution = new Solution();
        List<String> list = new ArrayList<String>();
        list = solution.fullJustify(words, L);

    }
}
