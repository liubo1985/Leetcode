package CC150.SimplifyPath;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        if(path == null){
            return null;
        }
        int len = path.length();
        int i = 0;
        Stack<String> stack = new Stack<String>();
        while(i < len){
            while(i < len && path.charAt(i) == '/'){
                i++;
            }
            if(i == len){
                break;
            }
            int start = i;
            while(i < len && path.charAt(i) != '/'){
                i++;
            }

            String element = path.substring(start, i);
            if("..".equals(element)){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else if(!".".equals(element)){
                stack.push(element);
            }
        }
        StringBuilder res = new StringBuilder();
        Stack<String> temp = new Stack<String>();
        while(!stack.isEmpty())
            temp.push(stack.pop());

        while(!temp.isEmpty())
            res.append("/"+temp.pop());

        if(res.length()==0)
            res.append("/");

        return res.toString();
    }
}