package com.CC150.MedianOfTwoSortedArrays;

/**
 * Created by bliu on 3/8/16.
 *
 * 首先考虑如何找到在A和B数组merge的第k个元素。可以对k进行分治。假设A的长度为m，B的长度为n，m<n，A的offset为aoffset，B的offset为boffset,初始为0

 如果m为0，返回B[k-1];
 如果k是1，返回A[aoffset]和B[boffset]中比较小的那个;
 我们从A中取前(相对于其offset的)Ka个(一般是k/2),从B中取前Kb个(Ka + Kb = k);
 比较A[aoffset + Ka-1]和B[boffset + Kb-1]。如果A[aoffset + Ka-1] 大于B[boffset + Kb-1],说明要找的第k个元素肯定不在B中刚刚选取
 的Kb个元素中，否则的话，在选择到的总共K个数中，最大的数应该在B中(但是实际在A中);反之，第k个元素肯定也不会在A中选取的Ka个元素中。也可以
 这样想，通过比较A[aoffset + Ka-1]和B[boffset + Kb-1]，我们知道在第3步中对K值的划分是否足够“偏向”目标元素，从而排除掉一部分元素;
 如果A[aoffset + Ka-1] 大于B[boffset + Kb-1],移动boffset到boffset+kb，同时k减去Kb。回到1.（相当于继续在A和新的B中寻找第k-Kb个元素）
 如果A[aoffset + Ka-1] 小于等于B[boffset + Kb-1],移动aoffset到aoffset+ka，同时k减去Ka。回到1.
 *
 *
 */
public class MedianOfTwoSortedArrays {
    private static int findKth(int A[], int aoffset, int m, int B[],int boffset, int n,int k){
            if(m > n) return findKth(B, boffset, n, A, aoffset, m, k);
            if(m==0)return B[k-1];
            if(k==1)return Math.min(A[aoffset], B[boffset]);
            int pa = Math.min(k/2, m);
            int pb = k - pa;
            if(A[aoffset + pa - 1] >= B[boffset + pb - 1])
                 return findKth(A,aoffset, m, B, boffset + pb, n - pb, k-pb);
            else return findKth(A, aoffset + pa, m - pa, B, boffset, n, k - pa);
            }


    public static double findMedianSortedArrays(int A[], int B[]) {

            //return findMiddleValue(A,B);//this is o(m+n)
            int n = A.length + B.length;
            if(n%2 == 0){
                return (double)(findKth(A,0,A.length, B,0,B.length,n/2) +findKth(A,0,A.length, B,0,B.length,n/2 + 1))/(double)2;
            }else {
                return findKth(A,0,A.length, B,0,B.length,n/2 + 1);
            }
    }
}
