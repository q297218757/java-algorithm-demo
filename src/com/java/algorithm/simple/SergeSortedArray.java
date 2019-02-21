package com.java.algorithm.simple;

/**
 * 合并两个排序的整数数组A和B变成一个新的数组
 * 给出 A = [1, 2, 3, empty, empty], B = [4, 5]
 *
 * 合并之后 A 将变成 [1,2,3,4,5]
 */
public class SergeSortedArray {

    /**
     * 第一种解法
     * 新建一个数组C，遍历该数组,根据数据的大小把数据插入C
     * 满足不了要求，领扣那里需要最后合并的的数据是A（相当于A有足够的长度存放B）
     * @param A 要合并的数组A
     * @param m  要合并的数组A的长度
     * @param B 要合并的数组B
     * @param n 要合并的数B的长度
     */
    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int[] C = new int[m+n];
        int indexA = 0;
        int indexB = 0;
       for (int j =0;j < C.length;j++){
           if(indexA>A.length-1){
               C[j] = B[indexB++];
           }else if(indexB>B.length-1){
               C[j] = A[indexA++];
           }else {
               if (A[indexA] > B[indexB]) {
                   C[j] = B[indexB];
                   indexB++;
               } else {
                   C[j] = A[indexA];
                   indexA++;
               }
           }
       }
       for (int o =0;o< C.length;o++){
           A[o] = C[o];
       }
    }

    /**
     * 第二次尝试
     * 基于第一次尝试上面更改，直接在数组A上面操作数据
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void mergeSortedArray2(int[] A, int m, int[] B, int n){
        int Aindex =A.length;
        while (Aindex>0){
            if(m == 0){
                //A数组的数字插入完了
                A[--Aindex] = B[--n];
            }else if (n == 0){
                //B数组的数字插入完了
                A[--Aindex] = A[--m];
            }else if(A[m-1]>=B[n-1]){
                A[--Aindex] = A[--m];
            }else {
                A[--Aindex] = B[--n];
            }
        }
    }
    public static void main(String[] args) {
        int[] A = {1,2,3,0,0};
        int[] B = {4,5};
        mergeSortedArray2(A,3,B,2);
    }
}
