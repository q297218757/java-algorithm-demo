package com.java.algorithm.simple;

/**
 * 螺旋数组
 */
public class SpiralArray {
    private int max = 0;

    public Boolean max(int num){
        if(num>max){
            return false;
        }else {
            return true;
        }
    }
    private int[][] sort(int[][] array,int n,int num,int cishu){

        int m = n;
        //第一步(y坐标网上)
        for (int i = 0;i<n-(2*cishu);i++){
            array[m--][n] = num++;
            dis(array);
            if(!max(num)){
                return array;
            }
        }
        m = n;
        //第二步斜着
        for (int i = 0;i<n;i++){
            array[i+2*cishu][m--] = num++;
            dis(array);
            if(!max(num)){
                return array;
            }
        }
        m = n;
        //第三步(x坐标)
        for (int i = cishu;i<n;i++){
            array[n][i] = num++;
            dis(array);
            if(!max(num)){
                return array;
            }
        }
        if(n != 0){
            sort(array,n-1,num,++cishu);
        }
        return array;
    }

    public void show(int n ){
        int num =0;
        for (int i = 1;i<=n;i++){
            num += i;
        }
        max = num;
        int[][] array = new int[n][n];
        array = sort(array,n-1,1,0);
    }
    public static void dis(int[][] array){
        for (int i= 0;i < array.length;i++){
            for (int k = 0;k <array[i].length;k++){
                if(array[i][k] == 0){
                    System.out.print(0+"  -  ");
                }else {
                    System.out.print(array[i][k]+"  -  ");
                }

            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        SpiralArray matrix = new SpiralArray();
        matrix.show(7);
    }

    public void sirt2(int n ){
        int[][] array = new int[n][n];
        int time =0;
        if(n % 2 ==0){
            time = n /2;
        }else {
            time = n /2 +1;
        }

    }

}
