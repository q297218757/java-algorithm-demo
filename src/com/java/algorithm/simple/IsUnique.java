package com.java.algorithm.simple;

/**
 * 判断字符串是否没有重复字符
 */
public class IsUnique {
    public static boolean isUnique(String str) {
        int[] ch=new  int[128];
        char[] s =str.toCharArray();
        for (int i=0; i<str.length(); ++i) {
            if (ch[s[i]] != 0) {
                return false;
            } else {
                ch[s[i]] = 1;
            }
        }
        return true;
    }
}
