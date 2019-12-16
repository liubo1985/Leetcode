public class Solution {
    /**
     * @param sentence: a list of string
     * @param rows: an integer
     * @param cols: an integer
     * @return: return an integer, denote times the given sentence can be fitted on the screen
     */

    // TextJustification 的简易版
    public int wordsTyping(String[] sentence, int rows, int cols) {
        // Write your code here
        if (sentence == null || sentence.length == 0){
            return rows * cols;
        }

        int colNum = 1;
        int len = sentence.length;
        int i = 0;
        int res = 0;
        while (colNum <= rows) {
            int j = i + 1;
            int size = 0;
            //每行的第一个单词指向i
            size += sentence[i].length();
            //如果这是j的值已经越界说明已经结束一轮，res++，j指向数组头
            if (j == len){
                j = 0;
                res++;
            }
            //看这行能装几个单词
            while (j < len && (size + 1 + sentence[j].length()) <= cols){
                size += 1 + sentence[j].length();
                j++;
                if (j == len){
                    j = 0;
                    res++;
                }

            }
            i = j;
            colNum++;
        }
        return res;
    }
}