public class Solution {
    /**
     * @param nums: A list of non negative integers
     * @return: A string
     */



    public String largestNumber(int[] nums) {
        // write your code here
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String s1, String s2){
                return (s2 + s1).compareTo(s1 + s2);
            }

        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        String result = sb.toString();
        int index = 0;
        while (index < result.length() && result.charAt(index) == '0') {
            index++;
        }
        if (index == result.length()) {
            return "0";
        }
        return result;
    }
}