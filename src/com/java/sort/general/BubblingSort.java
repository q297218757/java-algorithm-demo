package com.java.sort.general;

/**
 * 冒泡排序
 *
 * 冒泡算法的运作规律如下：
 *①、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 *②、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数（也就是第一波冒泡完成）。
 *③、针对所有的元素重复以上的步骤，除了最后一个。
 *④、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 *
 * 冒泡排序性能分析：
 *假设参与比较的数组元素个数为 N，则第一轮排序有 N-1 次比较，第二轮有 N-2 次，如此类推，这种序列的求和公式为：
 *（N-1）+（N-2）+...+1 = N*（N-1）/2
 *当 N 的值很大时，算法比较次数约为 N2/2次比较，忽略减1。
 *假设数据是随机的，那么每次比较可能要交换位置，可能不会交换，假设概率为50%，那么交换次数为 N2/4。不过如果是最坏的情况，初始数据是逆序的，那么每次比较都要交换位置。
 *交换和比较次数都和N2 成正比。由于常数不算大 O 表示法中，忽略 2 和 4，那么冒泡排序运行都需要 O(N2) 时间级别。
 *其实无论何时，只要看见一个循环嵌套在另一个循环中，我们都可以怀疑这个算法的运行时间为 O(N2)级，外层循环执行 N 次，内
 * 层循环对每一次外层循环都执行N次（或者几分之N次）。这就意味着大约需要执行N2次某个基本操作。
 */
public class BubblingSort {
    public static int[] sort(int[] array){
//        int temp;
//        //判断数组是否排序好了
//        boolean falg ;
//        //这个循环代表总共需要比较多少轮
//        for (int i = 1; i< array.length;i++){
//            //这个循环代表每一轮需要比较
//            falg  = true;
//            for (int k = 0;k<array.length-i;k++){
//                if(array[k] < array[k+1]){
//                    temp = array[k];
//                    array[k] = array[k+1];
//                    array[k+1] = temp;
//                    falg = false;
//                }
//            }
//            //这轮循环中没有发生位置变化,证明已经排列好了
//            if(falg){
//                return array;
//            }
//        }
        for (int i = 0;i < array.length;i++){
            for (int j = i;j<array.length-1;j++){
                int temp ;
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] i = {4,2,8,9,5,7,6,13};
        System.out.println(sort(i));
    }
}
