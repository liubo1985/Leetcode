package CC150.MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bliu on 4/24/16.
 * 可以利用两个指针扫描（两个指针分别为start，i），以S = “e b a d b a c c b”（忽略空格），T = “abc”为例：

 0 1 2 3 4 5 6 7 8

 初始化 start = i = 0
 i 逐渐往后扫描S直到窗口S[start…i]包含所有T的字符，此时i = 6（字符c的位置）
 缩减窗口：此时我们注意到窗口并不是最小的，需要调整 start 来缩减窗口。缩减规则为：如果S[start]不在T中 或者 S[start]在T中但是删除
 后窗口依然可以包含T中的所有字符，那么start = start+1， 直到不满足上述两个缩减规则。缩减后i即为窗口的起始位置，此例中从e开始窗口中要
 依次删掉e、b、a、d，start最后等于4 ，那么得到一个窗口大小为6-4+1 = 3
 start = start+1(此时窗口肯定不会包含所有的T中的字符)，跳转到步骤2继续寻找下一个窗口。本例中还以找到一个窗口start = 5，i = 8，
 比上个窗口大，因此最终的最小窗口是S[4…6]

 这道题是字符串处理的题目，和Substring with Concatenation of All Words思路非常类似，同样是建立一个字典，然后维护一个窗口。
 区别是在这道题目中，因为可以跳过没在字典里面的字符（也就是这个串不需要包含且仅仅包含字典里面的字符，有一些不在字典的仍然可以满足要求），
 所以遇到没在字典里面的字符可以继续移动窗口右端，而移动窗口左端的条件是当找到满足条件的串之后，一直移动窗口左端直到有字典里的字符不再
 在窗口里。在实现中就是维护一个HashMap，一开始key包含字典中所有字符，value就是该字符的数量，然后遇到字典中字符时就将对应字符的数量减一。
 算法的时间复杂度是O(n),其中n是字符串的长度，因为每个字符再维护窗口的过程中不会被访问多于两次。空间复杂度则是O(字典的大小)，也就是代码
 中T的长度
 **/

public class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0){
            return "";
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        //initialize hashmap
        for(int i = 0; i < t.length(); i++){
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            }
            else{
                map.put(t.charAt(i), 1);
            }
        }

        int counter = 0;
        int left = 0;
        int minleft = -1;
        int tLen = t.length();
        int min = Integer.MAX_VALUE;

        for(int right = 0; right < s.length(); right++){
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if(map.get(s.charAt(right)) >= 0){
                    counter++;
                }
                while(counter == tLen){
                    if(right - left + 1 < min){
                        min = right - left + 1;
                        minleft = left;
                    }
                    if(map.containsKey(s.charAt(left))){
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        //counter--;
                        if(map.get(s.charAt(left))>0)
                        {
                            counter--;
                            break;
                        }
                    }
                    left++;
                }

            }

        }
        if(minleft == -1){
            return "";
        }
        return s.substring(minleft, minleft + min);

    }
}