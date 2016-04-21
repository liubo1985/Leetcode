package CC150.SimplifyPath;

import java.util.Stack;

/*
当遇到“/../"则需要返回上级目录，需检查上级目录是否为空。

当遇到"/./"则表示是本级目录，无需做任何特殊操作。

当遇到"//"则表示是本级目录，无需做任何操作。

当遇到其他字符则表示是文件夹名，无需简化。

当字符串是空或者遇到”/../”，则需要返回一个"/"。

当遇见"/a//b"，则需要简化为"/a/b"。

根据这些要求，我需要两个栈来解决问题。

先将字符串依"/"分割出来，然后检查每个分割出来的字符串。

当字符串为空或者为"."，不做任何操作。

当字符串不为".."，则将字符串入栈。

当字符串为"..", 则弹栈（返回上级目录）。

当对所有分割成的字符串都处理完后，检查第一个栈是否为空，如果栈为空，则证明没有可以重建的目录名，返回"/"即可。

当第一个栈不为空时，这时候我们需要还原path。但是不能弹出栈，因为按照要求栈底元素应该为最先还原的目录path。

例如：原始path是 /a/b/c/，栈里的顺序是：a b c，如果依次弹栈还原的话是：/c/b/a（错误！），正确答案为：/a/b/c

所以这里我应用了第二个栈，先将第一个栈元素弹出入栈到第二个栈，然后再利用第二个栈还原回初始path。
*/
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