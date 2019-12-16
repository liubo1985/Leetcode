public class Solution {
    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source , String target) {
        // write your code here
        if (source == null || source.length() == 0){
            return "";
        }
        if (target == null || source.length() == 0){
            return "";
        }

        int[] map = new int[256];
        int counter = 0;
        for (int i = 0; i < target.length(); i++) {
            map[target.charAt(i)]++;
            counter++;
        }
        int sourceCounter = 0;
        int minWin = Integer.MAX_VALUE;
        int left = 0;
        int start = -1;

        for (int right = 0; right < source.length(); right++) {
            char cur = source.charAt(right);
            if (map[cur] > 0) {
                sourceCounter++;
            }
            map[cur]--;
            while(sourceCounter >= counter) {
                map[source.charAt(left)]++;
                if (map[source.charAt(left)] > 0) {
                    sourceCounter--;
                }
                if (minWin > right - left + 1) {
                    minWin = right - left + 1;
                    start = left;
                }
                left++;
            }
        }
        if (start == -1) {
            return "";
        }
        return source.substring(start, start + minWin);

    }
}