package com.java.algorithm.simple;

import java.util.*;

/**
 * 给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一。
 * 给出数组[1,1,1,1,2,2,2]，返回 1
 */
public class MajorityNumber {

    /**
     * 第一次尝试的思路
     * 先找到所有出现过的一次（不管出现的次数，只要出现过全部找到）
     * 遍历出现过得数，遍历集合中的所有数，相同的加1，最后比较是否是主元素
     * 时间复杂度是n^2，空间复杂度是n,不满足要求
     * @param nums 要查找主元素的数组
     * @return
     */
    public static int majorityNumber(List<Integer> nums) {
        // write your code here
        int num = -1;
        Map<Integer,Integer> map  = new HashMap<>();
        int[] numArray = new int[nums.size()];
        //先找到数据中出现过的所有的值
        for(int n = 0;n < nums.size();n++){
           if(map.containsKey(map.get(nums.get(n)))){
               map.put(nums.get(n), map.get(nums)+1);
           }else {
               map.put(nums.get(n), 1);
           }
        }
        //遍历出现过得值，查找有重复出现过多少次
        for (Integer in: map.keySet()){
            int m = 0;
            for(int n = 0;n < nums.size();n++){
                if(nums.get(n) == in){
                    m ++;
                }
            }
            //出现的次数大于数组长度的一半
            if(m > (nums.size()/2)){
                return in;
            }
        }
        return num;
    }

    /**
     * 第二种尝试
     * 使用map集合来存放出现过的数据和出现过的次数,如果已经存在这个kye就往value里面加一，如果没有存在，就把这个key的value值设置为1
     * @param nums
     * @return
     */
    public int majorityNumber2(List<Integer> nums){
        // write your code here
        int num = -1;
        Map<Integer,Integer> map  = new HashMap<>();
        int[] numArray = new int[nums.size()];
        //先找到数据中出现过的所有的值
        for(int n = 0;n < nums.size();n++){
            if(map.containsKey(nums.get(n))){
                map.put(nums.get(n), map.get(nums.get(n))+1);
            }else {
                map.put(nums.get(n), 1);
            }
        }
        //遍历出现过得值，查找有重复出现过多少次
        for (Integer in: map.keySet()){
            if(map.get(in)> nums.size()/2){
                return in;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        majorityNumber(list);
    }
}
