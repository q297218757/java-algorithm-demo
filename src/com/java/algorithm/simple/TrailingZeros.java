package com.java.algorithm.simple;

/**
 *  尾部的零
 *  设计一个算法，计算出n阶乘中尾部零的个数
 *  样例
 * 样例  1:
 * 	输入: 11
 * 	输出: 2
 *
 * 	样例解释:
 * 	11! = 39916800, 结尾的0有2个。
 *
 * 样例 2:
 * 	输入:  5
 * 	输出: 1
 *
 * 	样例解释:
 * 	5! = 120， 结尾的0有1个。
 */
public class TrailingZeros {
    /**
     *  暴力解法（不可取）
     *  求出n阶乘的值再余10这样子求
     * @param n
     * @return
     */
    public static long trailingZerosV1(long n) {
        // write your code here, try to do it without arithmetic operators.
        int m = 0;
        if(n==0){
            return 1;
        }
        long num=1;
        for (long i=n;i>0;i--){
            num *=i;
        }
        while (true){
            long j =num%10;
            if(j!=0){
                break;
            }
            num /=10;
            m++;
        }
        return m;
    }

    public static long trailingZerosV2(long n){
        long m=0;
        while (n>5){
            n = n/5;
            m +=n;
        }
        return m;
    }
    public static void main(String[] args) {
       System.out.println(trailingZerosV1(6));

    }
}
