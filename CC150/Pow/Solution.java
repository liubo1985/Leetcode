package com.CC150.Pow;

/**
 * Created by bliu on 4/10/16.
 * 有一点需要注意：
 int 类型范围 -2147483648~2147483647
 当n=-2147483648，则-n=2147483648超出2147483647，结果-n仍然是-2147483648，所以这个情况应该单独处理。

 也可以用机器码来解释这一个知识点：-2147483648的机器码为1000...0000（32位），实现取负：即机器码各位取反最后加1，得到的还是100....000。

 这也是第下面代码中 if(n<0 && n!=INT_MIN) return 1.0/pow(x,-n) 为什么这样写的原因，如果写成if(n<0) return 1.0/pow(x,-n)

 则会造成死循环
 */
public class Solution {
    public double myPow(double x, int n) {
        double temp;
        if(n == 0){
            return 1.0;
        } else if(n < 0 && n != Integer.MIN_VALUE){
            return 1.0/myPow(x, -n);
        }
        else if(n == Integer.MIN_VALUE){
            temp = myPow(x, -n/2);
            return 1.0/(temp*temp);
        }else if(n % 2 == 0){
            temp = myPow(x, n/2);
            return temp*temp;
        }else {
            temp = myPow(x, (n - 1)/2);
            return x*temp*temp;
        }

    }
}