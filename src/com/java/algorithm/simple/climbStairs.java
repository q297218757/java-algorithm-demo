package com.java.algorithm.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一系列的会议时间间隔，包括起始和结束时间[[s1,e1]，[s2,e2]，…(si < ei)，
 * 确定一个人是否可以参加所有会议。
 *
 * 输入: intervals = [(0,30),(5,10),(15,20)]
 * 输出: false
 * 解释:
 * (0,30), (5,10) 和 (0,30),(15,20) 这两对会议会冲突
 *
 * 输入: intervals = [(5,8),(9,15)]
 * 输出: true
 * 解释:
 * 这两个时间段不会冲突
 */
public class climbStairs {

    public static boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        Boolean aBoolean = true;
        int max =0;
        //默认第一个的开始值为最小值
        int min = intervals.get(0).start;
       for (Interval in: intervals){
            int start = in.start;
            int end = in.end;
            //找出最大值
            if(end > max){
                max = end;
            }
            //找出最小值
           if(min > start){
               min = start;
           }
       }
       int[] array = new int[max+1];
        for (Interval in: intervals){
            int start = in.start;
            int end = in.end;
            for (int i = start;i <= end;i++){
                if(array[i]!=0){
                    return false;
                }else {
                    array[i] = 1;
                }
            }
        }
       return aBoolean;
    }

    static class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }

    public static void main(String[] args) {
        //Interval interval = new Interval(0,30);
        Interval interval2 = new Interval(0,10);
        //Interval interval3 = new Interval(0,20);

        List list = new ArrayList();
        //list.add(interval);
        list.add(interval2);
       // list.add(interval3);

        System.out.println(canAttendMeetings(list));
    }
}
