package com.java.algorithm.simple;

/**
 * 落单的数
 * 给出2*n + 1 个的数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。
 * 样例
 * 给出 [1,2,2,1,3,4,3]，返回 4
 */
public class SingleNumber {

    public int singleNumber(int[] A) {
        // write your code here
        String srt ="" ;
        int num =0 ;
        for (int n =0;n<A.length;n++){
            Boolean b =false;
            for (int m =0;m<A.length;m++){
                if(m!=n&&A[n]==A[m]){
                    b=true;
                    break;
                }
            }
            if(!b){
                num=A[n];
                break;
            }
        }
        return num;
    }
}
