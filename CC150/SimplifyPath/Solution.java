public class Solution {
    /**
     * @param path: the original path
     * @return: the simplified path
     */
    public String simplifyPath(String path) {
        // write your code here
        if (path == null || path.length() == 0){
            return "";
        }

        String res = "/";
        String[] arr = path.split("/+");
        Stack<String> stack = new Stack<String>();

        for (String str : arr){
            if (str.equals(".") || str.equals("")){
                continue;
            } else if (str.equals("..")) {
                if (!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }

        while (!stack.isEmpty()){
            res = "/" + stack.pop() + res;
        }

        if (res.length() > 1) {
            return res.substring(0, res.length() - 1);
        }
        return res;
    }
}