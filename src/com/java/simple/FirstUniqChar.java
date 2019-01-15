package com.java.simple;

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

        String str = "ABACCab";
        char c = firstUniqChar(str);
        System.out.println(c);
    }
}
