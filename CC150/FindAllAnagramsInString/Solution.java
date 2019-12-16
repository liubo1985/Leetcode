public class Solution {
    /**
     * @param s: a string
     * @param p: a string
     * @return: a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        // write your code here
        int[] map = new int[26];
        List<Integer> res = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        int start = 0, end = 0, match = 0;
        for (char ch : p.toCharArray()){
            map[ch - 'a']++;
        }
        while (end < sLen){
            if (map[s.charAt(end) - 'a'] >= 1){
                match++;
            }
            map[s.charAt(end) - 'a']--;
            end++;
            if (match == pLen){
                res.add(start);
            }
            if (end - start == pLen){
                if (map[s.charAt(start) - 'a'] >= 0){
                    match--;
                }
                map[s.charAt(start) - 'a']++;
                start++;
            }
        }
        return res;
    }
}