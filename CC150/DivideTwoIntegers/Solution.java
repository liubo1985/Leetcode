package com.CC150.DivideTwoIntegers;

/**
 * Created by bliu on 3/21/16.
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0)
            return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        if(divisor == -1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        if(dividend == 0)
            return 0;

        boolean isNegative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);


        long div = Math.abs((long)dividend);
        long dis = Math.abs((long)divisor);
        long origin_dis = dis;
        /*
        整数近似除法：32/3 = 10

        显然求近似除法可以用乘法来二分查找：32 ~ 3*10 = 3*[1*(2^3) + 0*(2^2) + 1*(2^1) + 0*(2^0)]

        res = 0

        1. 先找到a使x*2^a <= y < x*2^(a+1)，res += 2^a，y = y - x*2^a

        2. if(y >= x*2^(a-1) {res+=2^(a-1); y = y - x*2^(a-1);}

        3. if(y >= x*2^(a-2) {res+=2^(a-2); y = y - x*2^(a-2);}

        ...

        但题目不允许用乘法，可以用移位代替：x*2^i = x<<i：

        先计算出a的最大值， 然后往回计算每一个右移幂的系数
         */
        int i = 0;
        while(div >= dis << (i + 1)){
            i++;
        }

        int res = 0;
        while(div >= origin_dis){
            if(div >= dis << i){
                div -= dis << i;
                res += 1 << i;
            }
            i--;
        }

        return isNegative? -res : res;

    }
}
