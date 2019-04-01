package com.java.algorithm.simple;

/**
 * 给出n个数，找出最大的m个
 */
public class MaximumN {
    public static void swap(int[] array, int x, int y) {
        int temp = 0;
        temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void sort(int[] array, int n, int left, int right, int mark) {
        int l = left;   //左边界
        int m = left;  //基准
        int r = right; //右边界
        while (r > m) {
            while (r > m) {
                if (array[r] > array[m]) {
                    swap(array, r, m);
                    m = r;
                    break;
                }
                r--;
            }
            while (r > m ) {
                if (array[l] < array[m]) {
                    swap(array, l, m);
                    m = l;
                    break;
                }
                l++;
            }
        }
        if (m == (n - 1)) {

        } else if (m > n) {
            sort(array, n, 0, m, 0);
        } else {
            sort(array, n, n, m, array.length - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        sort(array, 3, 0, array.length - 1, 0);
        System.out.println(array);
    }
}
