package com.java.algorithm.simple;

/**
 *  翻转字符串中的单词
 *  给定一个字符串，逐个翻转字符串中的每个单词。
 *  说明
 * 单词的构成：无空格字母构成一个单词
 * 输入字符串是否包括前导或者尾随空格？可以包括，但是反转后的字符不能包括
 * 如何处理两个单词间的多个空格？在反转字符串中间空格减少到只含一个
 * 样例
 * 给出s = "the sky is blue"，返回"blue is sky the"
 */
public class ReverseWords {
    /**
     * @param s 要翻转的字符串
     * @return
     */
    public static String reverseWords(String s) {
        // write your code here
        String test = s.replaceAll("\\s{1,}", " ");
        String[] strs = test.split(" ");
        if(strs.length==0){
            return s;
        }
        String s1 ="";
        for (int n=strs.length-1;n>=0;n--){
            s1+=strs[n];
            if(n!=0){
                s1+=" ";
            }
        }
        return s1;
    }
}
