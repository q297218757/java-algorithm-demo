package com.java.algorithm.simple;

import java.util.HashSet;
import java.util.Set;

/**
 *  第一个落单的数
 *  给出一个字符串，找到第一个只出现一次的字符
 */
public class FirstUniqChar {
    public static char firstUniqChar(String str) {
        // Write your code here
        char[] c = str.toCharArray();
        int n=0;
        while (true){
            boolean b =false;
            for (int k=0;k<c.length;k++){
                if(k!=n&&c[n]==c[k]){
                    b =true;
                    break;
                }
            }
            if(!b){
                break;
            }
            n++;
        }
        return c[n];
    }

    public static void main(String[] args) {

//        String str = "ABACCab";
//        char c = firstUniqChar(str);
//        System.out.println(c);
        System.out.println("fsdfdsfdsf".hashCode());
        Set set = new HashSet();
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int e = a;
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        set.add(e);
        String s = new String("s");
        String s2 = new String("s");
        set.add(s);
        set.add(s2);
        System.out.println(set.size());
        b = 4;
    }
}
