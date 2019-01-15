package com.java.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 水仙花数
 *
 */
public class NarcissisticNumber {
    /**
     * @param m 幂
     * @return
     */
    public List<Integer> Methon(int m){
        int num1 =1;
        for (int j = 0; j < m; j++) {
            num1*=10;
        }
        List<Integer> list = new ArrayList();
        Boolean flag =false;
        for (int n=0;n<num1;n++) {
            if(flag){
                break;
            }
            String str = String.valueOf(n);
            char[] c = str.toCharArray();
            int index = c.length;
            if(m==index){
                int num = 0;
                for (char c1 : c) {
                    num += Math.pow(Integer.parseInt(String.valueOf(c1)), index);
                    if(num>n){
                        flag =true;
                    }
                }
                if (num == n) {
                    list.add(n);
                }
            }
        }
        return list;
    }
}
