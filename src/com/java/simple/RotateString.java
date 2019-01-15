package com.java.simple;

/**
 * 旋转字符串
 * 给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
 * 样例  1:
 * 	输入:  str="abcdefg", offset = 3
 * 	输出: "efgabcd"
 * 	样例 2:
 * 	输入: str="abcdefg", offset = 0
 * 	输出: "abcdefg"
 */
public class RotateString {
    /**
     *
     * @param str 需要翻转的字符串
     * @param offset 偏移量
     */
    public  void Method(char[] str, int offset){
        if(str!=null&&str.length!=0){
            if (offset > str.length) {
                offset = offset % str.length;
            }
            String s2 = String.valueOf(str).substring(0, str.length - offset);
            String s3 = String.valueOf(str).substring(str.length - offset, str.length);
            String s = s3 + s2;
            char[] c = s.toCharArray();
            for (int n = 0; n < c.length; n++) {
                str[n] = c[n];
            }
        }
    }
}
