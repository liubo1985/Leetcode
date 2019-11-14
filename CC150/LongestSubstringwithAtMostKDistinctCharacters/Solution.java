public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null | s.length() == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char cha = s.charAt(i);
            if (map.containsKey(cha)){
                map.put(cha, map.get(cha) + 1);
            }else {
                map.put(cha, 1);
            }
            if (map.size() > k){
                max = Math.max(max, i - start);
                while (map.size() > k) {
                    char left = s.charAt(start);
                    if (map.get(left) == 1){
                        map.remove(left);
                    }else {
                        map.put(left, map.get(left) - 1);
                    }
                    start++;
                }
            }
        }
        max = Math.max(max, s.length() - start);
        return max;
    }
}