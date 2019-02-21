package com.java.algorithm.simple;

/**
 * 给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。如果没有，返回到它将会被按顺序插入的位置。
 *
 * 你可以假设在数组中无重复元素。
 *
 * [1,3,5,6]，5 → 2
 *
 * [1,3,5,6]，2 → 1
 *
 * [1,3,5,6]，7 → 4
 *
 * [1,3,5,6]，0 → 0
 */
public class SearchInsert {

    public static int searchInsert(int[] A, int target) {
        // write your code here
        if(A.length == 0 ){
            return 0;
        }else {
            return searchRecursive(A, 0, A.length-1, target);
        }
    }

    private static int searchRecursive(int[] array,int low,int hight,int target){
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
            if(target > array[hight]){
                return hight+1;
            }else if(target == array[hight]){
                return hight;
            }else if(target <= array[low]){
                return low;
            }else {
                return middle;
            }
        }
    }

    public int searchInsert2(int[] A, int target) {
        int mid;
        int lo = 0;
        int hi = A.length - 1;

        while (lo <= hi) {
            mid = lo + (hi - lo)/ 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    /*
       o(n)不好用
     */
    public static int searchInsert3(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(target <=nums[i]){
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] ints = {1,3,5,6};
        System.out.println(searchInsert(ints,6));
    }
}
