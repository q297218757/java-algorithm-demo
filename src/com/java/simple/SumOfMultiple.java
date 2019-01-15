package com.java.simple;

/**
 * 找得出A和B区间的3的倍数的所有数相加的和
 */
public class SumOfMultiple {
    public int getSum(int A, int B) {
        int num=0;
        for (int n=A;n<=B;n++){
            if(n%3==0){
                num+=n;
            }
        }
        return num;
    }
}
