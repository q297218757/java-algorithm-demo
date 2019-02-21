package com.java.algorithm.simple;

/**
 * 斐波拉契
 * 在数学上，斐波纳契数列以如下被以递推的方法定义：F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)
 */
public class Fibonacci {

    //基本的递归实现
    public int fib(int n)
    {
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fib( n-1)+fib(n-2);
    }

    //动态规划-自顶向下的备忘法
    public static int Fibonacci(int n)
    {
        if(n<=0) {
            return n;
        }
        //创建一个数据来存放
        int []Memo=new int[n+1];
        //把数组的值全部设为-1，相当于还没有数据
        for(int i=0;i<=n;i++) {
            Memo[i] = -1;
        }
        return fib(n, Memo);
    }
    public static int fib(int n,int []Memo)
    {
        //如果不为-1,证明这个位置的数据已经生成了, 直接返回就行
        if(Memo[n]!=-1) {
            return Memo[n];
        }
        //如果已经求出了fib（n）的值直接返回，否则将求出的值保存在Memo备忘录中。
        if(n<=2) {
            Memo[n] = 1;
        } else {
            Memo[n]=fib( n-1,Memo)+fib(n-2,Memo);
        }

        return Memo[n];
    }

    public static void main(String[] args) {
        int[] array = new int[7];
        System.out.println(Fibonacci(6));
    }
}
