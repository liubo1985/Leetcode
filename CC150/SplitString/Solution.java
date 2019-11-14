public class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        // write your code here
        List<String> list = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0){
            res.add(list);
            return res;
        }


        helper(s, 0, list, res);
        return res;
    }

    public void helper(String s, int pos, List<String> list, List<List<String>> res){

        if (pos == s.length()){
            res.add(list);
            return;
        }

        for (int i = pos; i < s.length() && i < pos + 2; i++) {
            String tmp = s.substring(pos, i + 1);
            list.add(tmp);
            helper(s, i + 1, new ArrayList<String>(list), res);
            list.remove(list.size() - 1);

        }
    }
}