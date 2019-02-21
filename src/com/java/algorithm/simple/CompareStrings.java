package com.java.algorithm.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 比较字符串
 * 比较两个字符串A和B，确定A中是否包含B中所有的字符。字符串A和B中的字符都是 大写字母
 * 给出 A = "ABCD" B = "ACD"，返回 true
 *
 * 给出 A = "ABCD" B = "AABC"， 返回 false
 */
public class CompareStrings {
    /**
     *  第一解题 的思路
     *  分别循环两个数组，不能满足要求
     * @param A 要比较的字符串A
     * @param B 要比较的字符串B
     * @return
     */
    public static boolean compareStrings(String A, String B) {
        // write your code here
        char[] charA = A.toCharArray();
        char[] charB = B.toCharArray();
        if(charB.length == 0){
            return true;
        }else if(charA.length == 0){
            return false;
        }
        int n = 0;
        for (int i =0;i<charA.length;i++){
            for (int j = 0;j< charB.length;j++){
                if(charA[i] == charB[j]){
                    n++;
                    if(n == charB.length){
                        return true;
                    }
                }
            }
        }
        return  false;
    }

    /**
     * 第二种解法
     * 在第一种方法的基础上创建一个和charA长度相等的整数数组，初始化所有的值都为-1，代表这个
     * 位置的值还没有被匹配过，如果被匹配过到了，就把这个数组的值改成 0
     * @param A
     * @param B
     * @return
     */
    public static boolean compareStrings2(String A, String B){
        char[] charA = A.toCharArray();
        char[] charB = B.toCharArray();
        if(charB.length == 0){
            return true;
        }else if(charA.length == 0){
            return false;
        }
        int[] intA = new int[charA.length];
        for (int n = 0;n<intA.length;n++){
            intA[n] = -1;
        }
        int m =0;

        for (int j = 0;j < charB.length;j++){
            Boolean flag = false;

            for (int k = 0;k< charA.length;k++){
                if(flag){
                    break;
                }
                if(charB[j]==(charA[k])&&intA[k]==-1){
                    m++;
                    intA[k] = 0;
                    flag = true;
                    if(m == charB.length){
                        return true;
                    }
                }
            }
            if(!flag){
                return false;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String A =  "ABCDE";
        String B = "AABC";
        compareStrings2(A,B);
    }
}
