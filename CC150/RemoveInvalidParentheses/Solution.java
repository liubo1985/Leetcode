public class Solution {
    /**
     * @param s: The input string
     * @return: Return all possible results
     */
    public List<String> removeInvalidParentheses(String s) {
        // Write your code here
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0){
            res.add("");
            return res;
        }
        // calculate the redundant（ or ）
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '('){
                l++;
            } else if (ch == ')'){
                if (l > 0){
                    l--;
                } else {
                    r++;
                }
            }
        }
        helper(l, r, s, res, 0);
        return res;
    }

    public void helper(int l, int r, String s, List<String> res, int pos){
        if (l == 0 && r == 0){
            if (valid(s)){
                res.add(s);
            }
        }
        for (int i = pos; i < s.length(); i++){
            if (i != pos && s.charAt(i) == s.charAt(i - 1)){
                continue;
            }

            if (s.charAt(i) == '('){

                if (l > 0){
                    String next = s.substring(0, i) + s.substring(i + 1);
                    helper(l - 1, r, next, res, i);
                }
            }

            if (s.charAt(i) == ')'){

                if (r > 0){
                    String next = s.substring(0, i) + s.substring(i + 1);
                    helper(l, r - 1, next, res, i);
                }
            }
        }
    }

    public boolean valid(String s){
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '('){
                l++;
            } else if (ch == ')'){
                if (l <= 0){
                    return false;
                }else {
                    l--;
                }
            }
        }
        return l == 0 && r == 0;
    }
}