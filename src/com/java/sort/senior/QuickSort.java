package com.java.sort.senior;

import java.util.*;

/**
 * 快速排序
 */
public class QuickSort {

    private void swap(int[] array,int j,int k){
        int temp = array[j];
        array[j] = array[k];
        array[k] = temp;
    }

    /*
     自己实现的快速排序
    1）设置两个变量i、j，排序开始的时候：i=0，j=array.length-1；
    2）以第一个数组元素作为关键数据，赋值给key，即key=A[0]；
    3）从j开始向前搜索，即由后开始向前搜索(j--)，找到第一个小于key的值A[j]，将A[j]和A[i]互换；
    4）从i开始向后搜索，即由前开始向后搜索(i++)，找到第一个大于key的A[i]，将A[i]和A[j]互换；
    5）重复第3、4步，直到i=j； (3,4步中，没找到符合条件的值，即3中A[j]不小于key,4中A[i]不大于key的时候改变j、i的值，使得j=j-1，i=i+1，直至找到为止。找到符合条件的值，进行交换的时候i， j指针位置不变。另外，i==j这一过程一定正好是i+或j-完成的时候，此时令循环结束
     一次遍历基准可能会发生多次变换
     */
    class Low{
        //排序的同时返回基准坐标
        private int sort(int[] array,int left,int right){
            int k = left;  //哨兵
            int i = left; //左起始点
            int j = right; //右起始点
            while (j > i) {
                //第一步
                while (j > i ) {
                    if (array[j] < array[k]) {
                        swap(array, j, k);
                        k = j;
                        break;
                    }
                    j--;
                }
                //第二步
                while (j > i) {
                    if (array[i] > array[k]) {
                        swap(array, i, k);
                        k = i;
                        break;
                    }
                    i++;
                }
            }
            return k;
        }

        public void  recQuickSort(int[] array,int left,int right){
            if(left > right){
                return;
            }else {
                int k = sort(array,left,right);
                recQuickSort(array,left,k-1);// 对上一轮排序(切分)时，基准元素左边的子数组进行递归
                recQuickSort(array,k+1,right);// 对上一轮排序(切分)时，基准元素右边的子数组进行递归
            }
        }
        //对外提供的排序方法,里面包括了第一次排序
        public void recQuickSort(int[] array){
            //第一次的基准点是相同的(为0)
            recQuickSort(array,0,array.length-1);
        }

   }

   /*
        网上大佬写的方法
        一次遍历基准只发生一次变化，i和j相同是交换基准
    */
    class Puls{
        int m =0;
       private  void recQuickSort(int[] array,int left,int right){
           if(right <= left){
               return;//终止递归
           }else{
               Low low = new Low();
              int partition = partitionIt(array,left,right);
               recQuickSort(array,left,partition-1);// 对上一轮排序(切分)时，基准元素左边的子数组进行递归
               recQuickSort(array,partition+1,right);// 对上一轮排序(切分)时，基准元素右边的子数组进行递归
           }
       }

       private  int partitionIt(int[] array,int left,int right){
           //为什么 j加一个1，而i没有加1,是因为下面的循环判断是从--j和++i开始的.
           //而基准元素选的array[left],即第一个元素，所以左游标从第二个元素开始比较
           int i = left;
           int j = right+1;
           int pivot = array[left];// pivot 为选取的基准元素（头元素）
           while(true){
               while(i<right && array[++i] < pivot){}

               while(j > 0 && array[--j] > pivot){}

               if(i >= j){// 左右游标相遇时候停止， 所以跳出外部while循环
                   break;
               }else{
                   m++;
                   swap(array, i, j);// 左右游标未相遇时停止, 交换各自所指元素，循环继续
               }
           }
           swap(array, left, j);//基准元素和游标相遇时所指元素交换，为最后一次交换
           m++;
           return j;// 一趟排序完成， 返回基准元素位置(注意这里基准元素已经交换位置了)
       }

       public  void sort(int[] array){
           recQuickSort(array, 0, array.length-1);
       }
    }

    public List<Integer> sort(List<Integer> list){
        int[] array = new int[list.size()];
        int n =0;
        for (int i:list){
            array[n++] = i;
        }
        QuickSort.Low quickSort = new QuickSort().new Low();
        quickSort.recQuickSort(array);
        List<Integer> sortList = new ArrayList<>();

        for (int i:array){
            sortList.add(i);
        }
        return sortList;
    }

   public static void main(String[] args) {
        QuickSort.Low low = new QuickSort().new Low();
        int[] array = {6,1,2,7,9,3,4,5,10,8,20,15,16,14};
//        int[] array = {9,8,7,6,5,4,3,2,1};
       low.recQuickSort(array);

//
//        int[] array1 = {6,1,2,7,9,3,4,5,10,8,20,15,16,14};
//        QuickSort.Puls puls = new QuickSort().new Puls();
//        puls.sort(array);

//       Map<String,List> map = new HashMap<>();
//       List list = new ArrayList();
//           map.put("1",list);
//       if(map.get("2") == null){
//           System.out.println("空");
//       }
//       List<List<List<Double>>> ringsList = new ArrayList<>();
//        Map<String,List<List<Double>>> map1 = new HashMap();
//       Iterator iterator = map1.keySet().iterator();
//       while (iterator.hasNext()){
//           ringsList.add(map1.get(iterator.next()));
//       }
       int i = 1;
       float d = 2;
       System.out.println(i/d);
    }
}
