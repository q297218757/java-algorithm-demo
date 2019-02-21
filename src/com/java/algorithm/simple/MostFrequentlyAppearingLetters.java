package com.java.algorithm.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串str,现在你需要统计出现次数最多的字母。返回这个字母出现的次数。
 * 给定str="ABCabcA",返回2。
 *
 * A出现了2次，B出现了1次，C出现了1次，a出现了1次，b出现了1次，c出现了1次，A出现的次数最多，所以返回2。
 */
public class MostFrequentlyAppearingLetters {
    public static  int mostFrequentlyAppearingLetters(String str) {
        // Write your code here.
        char[] c = str.toCharArray();
        int num =0;
        Map<String,Integer> map = new HashMap<>();
        for (char ch:c){
            if(map.containsKey(ch+"")){
                map.put(ch+"",map.get(ch+"")+1);
            }else {
                map.put(ch+"",1);
            }
        }

        for (String s:map.keySet()){
           if(map.get(s) > num){
               num = map.get(s);
           }
        }
        return num;
    }

    public static void main(String[] args) {
        String s = "ABCabcA";
        System.out.println(mostFrequentlyAppearingLetters(s));

    }
}
