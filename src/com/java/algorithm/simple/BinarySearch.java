package com.java.algorithm.simple;

/**
 *  二分查找
 *  给定一个排序的整数数组（升序）和一个要查找的整数target，用O(logn)的时间查找到target第一次出现的下标（从0开始）
 *  ，如果target不存在于数组中，返回-1。
 *  样例  1:
 * 	输入:[1,4,4,5,7,7,8,9,9,10]，1
 * 	输出: 0
 *
 * 	样例解释:
 * 	第一次出现在第0个位置。
 *
 * 样例 2:
 * 	输入: [1, 2, 3, 3, 4, 5, 10]，3
 * 	输出: 2
 *
 * 	样例解释:
 * 	第一次出现在第2个位置
 *
 * 样例 3:
 * 	输入: [1, 2, 3, 3, 4, 5, 10]，6
 * 	输出: -1
 *
 * 	样例解释:
 * 	没有出现过6， 返回-1
 *
 */
public class BinarySearch {
    /**
     * @param nums 整数数组
     * @param target 要查找的整数
     * 不好的实现(代码多)
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        // write your code here
        int low =0;
        int maxlen = nums.length-1;
        int middle =reMiddle(low,maxlen);
        while (true){
            if(target>nums[middle]){
                //要查找的数大于大子数组的最小值
                low = middle;
                if(middle==reMiddle(middle,maxlen)){
                    //只有两个数了
                    return -1;
                }else {
                    middle =reMiddle(middle,maxlen);
                }
            }else if(target<nums[middle]){
                //要查找的数小于大子数组的最小值
                maxlen = middle;
                if(middle==reMiddle(low,middle)){
                    //只有两个数了
                    return -1;
                }else {
                    middle =reMiddle(low,middle);
                }
            }else if(target == nums[middle]){
                break ;
            }else {
                return -1;
            }
        }
        //找到第一个匹配的数的下标
        for (int j =middle;j>=0;j--){
            if(nums[j] == nums[middle]){
                middle =j;
            }else {
                break;
            }
        }
        return middle;
    }

    public static int reMiddle(int low,int hight){
        return (low+hight)/2;
    }

    /**
     * @param nums 整数数组
     * @param target 要查找的整数
     * 改进过的算法(代码少，但是运行时间要长一点  )
     * @return
     */
    public static int binarySearch2(int[] nums, int target){
        if(nums.length == 0 ){
            return 0;
        }else {
            int middle = searchRecursive(nums, 0, nums.length-1, target);
            //找到第一个匹配的数的下标
            for (int j = middle; j >= 0; j--) {
                if (nums[j] == nums[middle]) {
                    middle = j;
                } else {
                    break;
                }
            }
            return middle;
        }
    }
    public static int searchRecursive(int[] array,int low,int hight,int target){
        int middle =(low+hight)/2;
            if(middle != low && middle != hight){
                int middlevalue = array[middle];
                if(middlevalue==target){
                    return middle;
                }else if(middlevalue>target){
                   return searchRecursive(array,0,middle-1,target);
                }else {
                    return searchRecursive(array,middle+1,hight,target);
                }
            }else {
                if(target==array[low]){
                    return  low;
                }else {
                    return -1;
                }
            }
    }

    public static void main(String[] args) {
        int[] ints = {1,2,3,4,5,6};
//         int[] ints = {9};
       System.out.println(binarySearch2(ints,9));

//        System.out.println((6+6)/2);
    }
}
