package com.java.algorithm.simple;

import java.util.ArrayList;
import java.util.List;

/**
 *  最大子数组
 *  给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
 *
 *  样例1:
 * 给出数组[−2,2,−3,4,−1,2,1,−5,3]，符合要求的子数组为[4,−1,2,1]，其最大和为6
 * 样例2:
 * 给出数组[1,2,3,4]，符合要求的子数组为[1,2,3,4]，其最大和为10
 */
public class MaxSubArray {
    /**
     * 第一次尝试的思路
     * 1.找到所有大于0的数据的下标
     * 2.存在大于0的下标遍历所有大于0的的下标，往后移动寻找子数组。没有大于0的数据，直接遍历整个数组
     * 3.比较子数组
     * 总结：运行速度非常慢
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int sum=0;
        List<Integer> list = new ArrayList<>();
        int n = 0;
        //找到所有大于0的数据的下标
        for (int i:nums){
            if(i>0){
                list.add(n);
            }
            n++;
        }
        int k;
        if(list.size()>0){
            //遍历所有大于0的下标
            for (int i: list){
                 k =nums[i];
                if(k>sum){
                    sum = k;
                }
                for (int m = i;m<nums.length-1;m++){
                    if(k+nums[m+1]>0){
                        k += nums[m+1];
                        if(k>sum){
                            sum = k;
                        }
                    }else {
                        break;
                    }
                }
            }
        }else{
            k = nums[0];
            for (int o =0;o<nums.length;o++){
                if(nums[o]>k){
                    k = nums[o];
                }
            }
            sum = k;
        }
        return sum;
    }

    /**
     * 第二次尝试的思路
     * 使用动态规划，把大问题分成小问题，从头遍历，算出每一位的最大子数组
     * @param nums 要查找最大子数组的数组
     * @return
     */
    public static int maxSubArray2(int[] nums){
        int maxSub;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        maxSub = dp[0];
        int temp = 0;
        for (int i = 1; i<nums.length;i++){
            if (dp[i-1] <= 0 ){
                //前面的<0,直接丢弃
                dp[i] = nums[i];
                temp = i;//记录起始位置
            }else {
                dp[i] = nums[i] +dp[i-1];
            }
            if(dp[i] > maxSub){
                //大于之前的最大值
                maxSub = dp[i];
            }
        }
        return maxSub;
    }
    public int fib(int n)
    {
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        return fib( n-1)+fib(n-2);
    }

    public static int maxSubArray3(int[] nums){
        int maxnum = 0;
        for (int i = 0; i < nums.length;i++ ){
            for (int j = i;j < nums.length;j++){
                int thisnum = 0;
                for (int k = i ;k<=j ;k++){
                    thisnum +=nums[k];
                    if(thisnum > maxnum){
                        maxnum = thisnum;
                    }
                }
            }
        }
        return maxnum;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
       int[] array ={-2,2,-3,4,-1,2,1,-5,3};
//
//        System.out.println(maxSubArray.maxSubArray(array));
        System.out.println(maxSubArray2(array));
    }
}
