package com.java.sort.general;

/**
 * 直接插入排序
 *
 * 直接插入排序基本思想是每一步将一个待排序的记录，插入到前面已经排好
 * 序的有序序列中去，直到插完所有元素为止。
 *
 * 插入排序性能分析：
 *
 * 在第一轮排序中，它最多比较一次，第二轮最多比较两次，一次类推，第N轮，最多比较N-1次。因此有 1+2+3+...+N-1 = N*（N-1）/2。
 * 假设在每一轮排序发现插入点时，平均只有全体数据项的一半真的进行了比较，我们除以2得到：N*（N-1）/4。用大O表示法大致需要需要 O(N2) 时间级别。
 * 复制的次数大致等于比较的次数，但是一次复制与一次交换的时间耗时不同，所以相对于随机数据，插入排序比冒泡快一倍，比选择排序略快。
 * 这里需要注意的是，如果要进行逆序排列，那么每次比较和移动都会进行，这时候并不会比冒泡排序快
 */
public class InsertionSort {
    /*
    自己的方法（没能完成）
    思路：创建一个新数组，每轮排序找到要插入的位置，插入
     */
    public static int[] sort(int[] array){
        int[] temparray = new int[array.length];
        temparray[0] = array[0];
        for (int i = 1;i < array.length;i++){
            for (int k = 0;k < i;k++){
                if(array[i] < temparray[k] ){
                    if(k == 0){
                        temparray[k] = 0;
                    }
                }
            }
        }
        return array;
    }

    //网上大佬的方法
    public static int[] sortPlus(int[] array){
        int j;
        int temp;
        //从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1;i < array.length;i++){
            temp= array[i]; //要插入的数
            j = i;
            //从已经排序的序列最右边的开始比较，找到比其小的数
            while (j > 0 && temp < array[j-1]){
                array[j] = array[j-1]; //向后挪动
                j--;
            }
            array[j] = temp; //存在比其小的数，插入
        }
        return array;
    }
    public static void main(String[] args) {
        int[] i = {4, 2, 8, 9, 5, 7, 6, 13};
        System.out.println(sortPlus(i));
    }
}
