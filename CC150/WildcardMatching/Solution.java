package com.CC150.WildcardMatching;

/**
 * Created by bliu on 4/6/16.
 *
 * 依然是正则表达式，但是数据强了一些，递归的算法虽然很好想写出来很漂亮但是无法通过比较恶心的case，原因是在匹配“*”的时候用到了逐次匹配
 * 的思想，让“*”匹配到的字符尽量少，如果一直不成功才会逐渐多地匹配字符，直到最后匹配了整个剩余串。这样如果存在多个“*”的话，就会导致递归
 * 开销急剧增大，最终TLE掉。

 所以这里我们需要引入一个漂亮的贪心思想来解决问题。首先我们遍历s，对几种可能的状态进行处理：如果当前*s和*p中有一个是问号，或者这两个
 字符相等，那么两个指针均后移一位，指向下一个字符；如果*p是一个星号通配符，则保存这个星号的位置，以及当前匹配到的位置，并将指针p向后
 移动一位；这样，当下一次匹配失败的时候，我们就可以有机会直接让先前那个星号多匹配一个字符——星号的定义原本是尽量少地匹配字符，如果我们
 只在匹配失败的时候才往前回溯让星号多进行匹配，自然会节省大量的递归开销。最后，利用这个巧妙的贪心优化，我们就可以得到一个更高效的
 匹配算法了。需要注意的一点是，如果最后匹配完了所有的s，但是*p还是非空，则要判断一下剩余的p串是否都是星号。如果是的话，同样可以返回true。


 */

public class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        int i = 0, j = 0;
        int star = -1;
        int position = 0;
        while(i < sLen){

            if(j < pLen && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){
                i++;
                j++;
            }
            else if(j < pLen && p.charAt(j) == '*'){
                star = j++;
                position = i;
            }
            else if(star != -1){
                i = ++position;
                //we should keep the value of star, DO NOT do star++, star will change otherwise.
                j = star + 1;
            }
            else
                return false;

        }

        //check if rest of p are '*'
        while(j < pLen && p.charAt(j) == '*'){
            j++;
        }
        return j == pLen? true : false;
    }

}