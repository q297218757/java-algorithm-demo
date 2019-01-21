package com.java.algorithm.simple;

/**
 * 合法的标识符
 * 合法的标识符由字母（A-Z，a-z）、数字（0-9）和下划线组成，并且首字符不能为数字。
 */
public class IsLegalIdentifier {
    public static  boolean isLegalIdentifier(String str) {
        // Write your code here.
        try {
            Integer.parseInt(str.substring(0,1));
            return false;
        }catch (Exception e){
            return str.matches("^[0-9a-zA-Z_]{1,}$");
        }
    }
}
