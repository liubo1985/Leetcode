

public class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */

    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if (s == null || s.length() == 0){
            return true;
        }

        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        int max = maxLength(dict);
        for (int i = 1; i <= s.length(); i++){
            for (int j = 1; j <= i && j <= max; j++){
                if (res[i - j] == false){
                    continue;
                }
                String word = s.substring(i - j, i);
                if (dict.contains(word)){
                    res[i] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }

    public int maxLength(Set<String> dict){
        int max = Integer.MIN_VALUE;
        for (String str : dict){
            max = Math.max(max, str.length());
        }
        return max;
    }
}