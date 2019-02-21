package com.java.algorithm.simple;

/**
 * 合并排序数组
 * 合并两个排序的整数数组A和B变成一个新的数组。新数组也要有序。
 * 样例  1:
 * 	输入: A=[1], B=[1]
 * 	输出:[1,1]
 *
 * 	样例解释:
 * 	返回合并后的数组。
 *
 * 样例 2:
 * 	输入: A=[1,2,3,4], B=[2,4,5,6]
 * 	输出: [1,2,2,3,4,4,5,6]
 *
 * 	样例解释:
 * 	返回合并后的数组。
 */
public class MergeSortedArray {
    public static int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        int[] C = new int[A.length+B.length];
        int Aindex =0;
        int Bindex = 0;
        int Cindex = 0;
        while (Cindex!=C.length){
            if(Aindex == A.length){
                //A数组的数字插入完了
                C[Cindex++] = B[Bindex++];
            }else if (Bindex == B.length){
                //B数组的数字插入完了
                C[Cindex++] = A[Aindex++];
            }else if(A[Aindex]>=B[Bindex]){
                C[Cindex++] = B[Bindex++];
            }else {
                C[Cindex++] = A[Aindex++];
            }
        }
        return C;
    }

}
