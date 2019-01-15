package com.java.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 对于一个给定的 source 字符串和一个 target 字符串，你应该在 source 字符串中找出 target
 * 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。
 * @return: return the index
 */
public class StrStr {
    public static int strStr(String source, String target) {
        char[] souchar = source.toCharArray();
        char[] tarchar = target.toCharArray();
        if(tarchar.length==0){
            return 0;
        }
        int n =-1;
        List<Integer> list = new ArrayList();
        //找到要匹配的第一个字母的位置
        for (int m=0;m<souchar.length;m++){
            if(tarchar[0]==souchar[m]){
                list.add(m);
            }
        }
        boolean b =true;
        for (int m=0;m<list.size();m++){
            int index=list.get(m);
            int t = index;
            int j =0;
            while (j<tarchar.length&&index<souchar.length){
                if(tarchar[j++]!=souchar[index++]){
                    b =false;
                    break;
                }
            }
            if(j==tarchar.length){
                n=t;
                break;
            }
        }
        return n;
    }
}
