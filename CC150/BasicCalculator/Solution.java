public class Solution {
    /**
     * @param s: the given expression
     * @return: the result of expression
     */
    public int calculate(String s) {
        // Write your code here
        if(s == null || s.length() == 0){
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        int number = 0;
        int sign = 1;
        for (Character ch : s.toCharArray()){
            if (Character.isDigit(ch)){
                number = 10 * number + ch - '0';
            }
            if (ch == '+'){
                number = number * sign;
                res += number;
                number = 0;
                sign = 1;
            }
            if (ch == '-'){
                number = number * sign;
                res += number;
                number = 0;
                sign = -1;
            }
            if (ch == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                number = 0;
                sign = 1;
            }
            if (ch == ')') {
                res += number * sign;
                sign = stack.pop();
                res =  res * sign + stack.pop();
                number = 0;
            }
        }

        if (number != 0) {
            res += sign * number;
        }

        return res;
    }
}