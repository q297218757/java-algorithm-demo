package com.java.structure.queue;

/**
 * 单向循环队列（用数组实现）
 */
public class MyQueue {
    //存放队列的数组
    private Object[] QueueArray;
    //队列总大小
    private int maxSize;
    //头(数组下标)
    private int head;
    //尾(数组下标)
    private int tail;
    //队列中的实际长度
    private int realSize;

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        QueueArray = new Object[maxSize];
        this.head =0;
        this.tail =-1;
        this.realSize =0;
    }
    //入队(队尾上移，队头不动)
    public void insert(Object s){
        if(isFull()){
            System.out.println("队列已经满了！！！");
        }else {
            if (tail==maxSize-1){
                //队尾指向数组末尾了，绕回来指向开始位置
                tail = -1;
            }
            QueueArray[++tail] = s;
            realSize++;
        }
    }

    //移除数据（队头上移，队尾不变）
    public Object remove(){
        Object o =null ;
        if (!isNull()){
            //队列不为空
            o =QueueArray[head];
            QueueArray[head] = null;
            //队头上移
            head++;
            //队头上移后等于数组最大长度，队头绕回去指向起始位置
            if(head==maxSize){
                head = 0;
            }
            realSize--;
            return o;
        }

        return o;
    }
    /**
     * 判断队列是否满了
     * @return
     */
    public boolean isFull(){
        if(realSize==maxSize){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isNull(){
        if(realSize==0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 查看队头数据
     * @return
     */
    public Object peekHead(){
        return  QueueArray[head];
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(5);

        myQueue.insert("s");
        myQueue.insert("w");
        myQueue.insert("e");
        myQueue.insert("r");
        myQueue.remove();
        myQueue.insert("t");
        myQueue.insert("y");
        myQueue.insert("u");
        System.out.println(myQueue.peekHead());
    }
}
