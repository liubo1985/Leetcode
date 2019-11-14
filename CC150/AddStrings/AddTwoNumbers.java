public class Solution {
    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        // write your code here
        int i = num1.length() - 1, j = num2.length() - 1;
        int flag = 0;
        int len = Math.max(num1.length(), num2.length());
        char[] temp = new char[len];
        int index = len - 1;
        while (i >= 0 && j >= 0){
            int digit1 = num1.charAt(i) - '0';
            int digit2 = num2.charAt(j) - '0';
            temp[index] =  (char)((digit1 + digit2 + flag) % 10 + '0');
            System.out.println(temp[index]);
            flag = (digit1 + digit2 + flag) / 10;
            index--;
            i--;
            j--;
        }
        while (i >= 0){
            int add = num1.charAt(i) - '0';
            temp[index] = (char)((add + flag) % 10 + '0');
            System.out.println(temp[index]);
            flag = (add + flag) / 10;
            index--;
            i--;
        }
        while (j >= 0){
            int add = num2.charAt(j) - '0';
            temp[index] = (char)((add + flag) % 10 + '0');
            System.out.println(temp[index]);
            flag = (add + flag) / 10;
            index--;
            j--;
        }
        String res = String.valueOf(temp);
        if (flag != 0){
            res = "1" + res;
        }
        return res;
    }
}