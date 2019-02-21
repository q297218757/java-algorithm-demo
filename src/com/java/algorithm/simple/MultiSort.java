package com.java.algorithm.simple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 多关键字排序
 * 给定 n 个学生的学号(从 1 到 n 编号)以及他们的考试成绩，表示为(学号，考试成绩)，请将这些学生按考试成绩降序排序，若考试成绩相同，则按学号升序排序。
 *
 * 样例
 * 样例1
 *
 * 输入: array = [[2,50],[1,50],[3,100]]
 * 输出: [[3,100],[1,50],[2,50]]
 * 样例2
 *
 * 输入: array = [[2,50],[1,50],[3,50]]
 * 输出: [[1,50],[2,50],[3,50]]
 */
public class MultiSort {
    /*
         第一次尝试
        实际上是整数排序问题
        使用插入排序
     */
    public static int[][] multiSort(int[][] array) {
        // Write your code here
        int[][] newArray = new int[array.length][array[0].length];
        int j;
        //成绩排序
        for (int i =1;i<array.length;i++){
            int num = array[i][1];//要插入的整数
            j = i;
            while (j > 0 && num >= array[j-1][1]){
                array[j][1] = array[j-1][1];
                j--;
            }
            array[j][1] = num;
        }
//        //相同成绩时学号排序
//        Map<Integer, List<Integer>> map  = new HashMap<>();
//        for (int i =1;i<array.length;i++){
//            //找到所有成绩相同的
//
//        }
        return array;
    }

    public static void main(String[] args) {
        int[][] in  = {{2,60},{1,50},{3,100}};
        multiSort(in);
    }
}
