package com.java.algorithm.simple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  尾部的零
 *  设计一个算法，计算出n阶乘中尾部零的个数
 *  样例
 * 样例  1:
 * 	输入: 11
 * 	输出: 2
 *
 * 	样例解释:
 * 	11! = 39916800, 结尾的0有2个。
 *
 * 样例 2:
 * 	输入:  5
 * 	输出: 1
 *
 * 	样例解释:
 * 	5! = 120， 结尾的0有1个。
 */
public class TrailingZeros {
    /**
     *  暴力解法（不可取）
     *  求出n阶乘的值再余10这样子求
     * @param n
     * @return
     */
    public static long trailingZerosV1(long n) {
        // write your code here, try to do it without arithmetic operators.
        int m = 0;
        if(n==0){
            return 1;
        }
        long num=1;
        for (long i=n;i>0;i--){
            num *=i;
        }
        while (true){
            long j =num%10;
            if(j!=0){
                break;
            }
            num /=10;
            m++;
        }
        return m;
    }

    public static long trailingZerosV2(long n){
        long m=0;
        while (n>5){
            n = n/5;
            m +=n;
        }
        return m;
    }
    class ProxyFactory{
        // 接收一个目标对象
        private Object target;

        public ProxyFactory(Object target) {
            this.target = target;
        }

        public Object getProxyInstance(){
            Object  proxy  = Proxy.newProxyInstance(
                    target.getClass().getClassLoader(), // 目标对象使用的类加载器
                    target.getClass().getInterfaces(), // 目标对象实现的所有接口
                    new InvocationHandler() { // 执行代理对象方法时候触发
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            // 获取当前执行的方法的方法名
                            String methodName = method.getName();
                            //方法返回值
                            Object result = null;
                            if ("find".equals(methodName)) {
                                // 直接调用目标对象方法
                                result = method.invoke(target, args);
                            } else {
                                System.out.println("开启事务...");
                                // 执行目标对象方法
                                result = method.invoke(target, args);
                                System.out.println("提交事务...");
                            }
                            return result;
                        }
                    }
            );
         return proxy;
        }
    }
    class base{
        private  String name ="亿欧";
        public void say(){
            System.out.println(name);
        }

    }
    public static void main(String[] args) {
      //  System.out.println(trailingZerosV1(6));
//        TrailingZeros trailingZeros = new TrailingZeros();
//        System.out.println(trailingZeros.getClass().getName());
//
//       Class s = TrailingZeros.class;
//        System.out.println(s == trailingZeros.getClass());
//
//        try {
//            Class aClass = Class.forName("com.java.algorithm.simple.TrailingZeros");
//             System.out.println("getClassLoader:"+aClass.getClassLoader());
//            System.out.println("getInterfaces:"+aClass.getInterfaces());
//            System.out.println(aClass == trailingZeros.getClass());
//        }catch(ClassNotFoundException e){
//            e.printStackTrace();
//        }

        Class bas = base.class;
        System.out.println(bas);
        try {
            Class b = Class.forName("com.java.algorithm.simple.TrailingZeros$base");
            System.out.println(b);
            //System.out.println(bas == b);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
