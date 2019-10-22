public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    // 每个单词后边加一个":;" 做分隔
    public String encode(List<String> strs) {
        // write your code here
        if (strs == null || strs.size() == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String connector = ":;";
        for (int i = 0; i < strs.size(); i++){
            String cur = strs.get(i);
            for (char ch : cur.toCharArray()){
                if (ch == ':'){
                    sb.append("::");
                } else {
                    sb.append(ch);
                }
            }

            sb.append(connector);

        }
        System.out.println(sb);
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (str == null || str.length() == 0){
            return res;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); ){
            char ch = charArray[i];
            if (ch == ':'){
                if (charArray[i + 1] == ':'){
                    sb.append(ch);
                    i += 2;
                } else {
                    res.add(sb.toString());
                    sb = new StringBuilder();
                    i += 2;
                }

            } else {
                sb.append(ch);
                i++;
            }
        }
        return res;
    }
}