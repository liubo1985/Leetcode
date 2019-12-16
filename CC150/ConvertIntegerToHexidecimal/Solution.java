public class Solution {
    public String toHex(int num) {
        if(num == 0) {
            return "0";
        }
        String ans = "";
        int len = 0;
        while(num != 0 && len < 8) {
            //15的二进制：1111
            int bit = num & 15;
            if(bit < 10) {
                //0 - 9
                ans = (char)('0' + bit) + ans;
            }
            else {
                //a - f
                ans = (char)('a' + bit - 10) + ans;
            }
            //位运算，对二进制的num右移4位相当于除以16
            num >>= 4;
            len++;
        }
        return ans;
    }
}