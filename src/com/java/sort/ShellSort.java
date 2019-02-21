package com.java.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 排序原理：希尔排序通过加大插入排序中元素的间隔，并在这些有间隔的元素中进行插入排序，从而使数据项能够大跨度的移动。当
 * 这些数据项排过一趟序后，希尔排序算法减小数据项的间隔再进行排序，依次进行下去，最后间隔为1时，就是我们上面说的简单的直接插入排序。
 */
public class ShellSort {
    /*
        网上的方法
        knuth（3h+1）间隔序列的希尔排序算法实现
     */
    public static void shellKnuthSort(int[] array){
        System.out.println("原数组"+array.toString());
        int step = 1; //插入的间隔
        int len = array.length;

        while (step <= len/3){
            step = step*3+1;
        }
        while (step > 0){
            for (int i = step;i < len;i++){
                int temp  =array[i];
                int j = i;
                while (j > step-1 && temp <array[j- step] ){
                    array[j] = array[j-step]; //数据后移
                    j -= step; //更改为该间隔下的前一个下标
                }
                array[j] = temp; //插入数据
            }
            System.out.println("间隔为"+step+"的排序结果为"+ Arrays.toString(array));
            step = (step-1)/3; //缩小间隔（最终变为1）
        }
    }

    /*
        自己的实现
        间隔为2h的希尔排序算法实现
     */
    public static void shellTwoSort(int[] array){
        int step = 1;
        int len = array.length;
        for (step = len/2 ;step > 0 ; step /= 2){
            for (int i = step; i < array.length; i++) {
                int temp = array[i]; //要插入的数
                int j = i;
                while (j > step - 1 && temp < array[j - step]) {
                    array[j] = array[j - step]; //数据后移
                    j -= step; //更改为该间隔下的前一个下标
                }
                array[j] = temp;
            }
            System.out.println("间隔为"+step+"的排序结果为"+ Arrays.toString(array));
        }
    }
    public static void main(String[] args) {
        int[] array = {4,2,8,9,5,7,6,1,3,10,3};
        shellTwoSort(array);
    }
}
