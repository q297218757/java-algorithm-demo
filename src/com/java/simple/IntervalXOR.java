package com.java.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 区间异或
 */
public class IntervalXOR {
    public  List<Integer> intervalXOR(int[] A, List<Interval> query) {
        List<Integer> list = new ArrayList();
        for (Interval in:query){
            int start =in.start;
            int end = in.end;
            int num =A[start];
            for (int n=start+1;n<=start+end-1;n++){
                num ^=A[n];
            }
            list.add(num);
        }
        return list;
    }

     class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
