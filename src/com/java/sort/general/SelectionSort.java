package com.java.sort.general;

/**
 * 选择排序
 * 选择排序是每一次从待排序的数据元素中选出最小的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完。
 * 分为三步：
 * ①、从待排序序列中，找到关键字最小的元素
 * ②、如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换
 * ③、从余下的 N - 1 个元素中，找出关键字最小的元素，重复(1)、(2)步，直到排序结束
 *
 *选择排序性能分析：
 *选择排序和冒泡排序执行了相同次数的比较：N*（N-1）/2，但是至多只进行了N次交换。
 *当 N 值很大时，比较次数是主要的，所以和冒泡排序一样，用大O表示是O(N2) 时间级别。但是由于选择排序交换的次数少，所以选择排序无疑是比冒泡排序快的。
 *当 N 值较小时，如果交换时间比选择时间大的多，那么选择排序是相当快的
 */
public class SelectionSort {
    /*
    自己写的排序方法
     */
    public static int[] sort(int[] array) {
        int min;
        int index = 0;
        //判断一轮排序中最小值是否发生变化
        boolean b;
        for (int i = 0; i < array.length; i++) {
            b = false;
            //初始最小值为开始排序下标的值
            min = array[i];
            for (int k = i + 1; k < array.length; k++) {
                //如果有比min还小的值，把它当做新的min
                if (array[k] < min) {
                    b = true;
                    min = array[k];
                    index = k;
                }
            }
            //如果这轮操作中存在最小值改变
            if (b) {
                array[index] = array[i];
                array[i] = min;
            }
        }
        return array;
    }

    /*
    网上大佬写的排序方法
    和自己写的比较:大佬这里关注点是最小值的下标，而我那里关注的直接就是最小值，我这样反而还要回头找下标，多此一举了。
     */
    public static int[] sortPlus(int[] array){
        int min;
        int temp;
        for (int i = 0;i < array.length-1;i++){
            min = i;
            for (int k = i;k < array.length;k++){
                if(array[min] > array[k]){
                    min = k;
                }
            }
            if(min != i){
                temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }
        return array;
    }
    public static void main(String[] args) {
        int[] i = {4, 2, 8, 9, 5, 7, 6, 13};
        System.out.println(sortPlus(i));
    }
}
