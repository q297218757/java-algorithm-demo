package com.java.structure.queue;

/**
 * 最小优先队列(用数组实现)
 */
public class PriorityQueue {
    //存放队列的数组
    private int[] QueueArray;
    //队列总大小
    private int maxSize;
    //头(数组下标)
    private int head;
    //尾(数组下标)
    private int tail;
    //队列中的实际长度
    private int realSize;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        QueueArray = new int[maxSize];
        this.head = 0;
        this.tail = -1;
        this.realSize = 0;
    }

    /**
     * 入队
     * 分成二步：
     * 1.判断队列是否已经满了
     * 2.判断队列是否是空队列
     * 3.从队尾开始找合适的入队位置
     * @param i
     */
    public void insert(int i){
        //1.判断队列是否已经满了
        if(isFull()){
            System.out.println("队列已经满了");
        }else if (isNull()){
            //2.判断队列是否是空队列
            QueueArray[++tail] = i;
            realSize++;
        } else {
            int index = tail;
            //3.从队尾开始找合适的入队位置
            //如果index等于-1相当于要比较的下标为数据尾
            while (i<QueueArray[index==-1?(maxSize-1):index]){
                QueueArray[index+1] = QueueArray[index];
                if(index==-1){
                    //
                    index =maxSize-1;
                }
                index--;
            }
            //插入数据，队尾上移
            QueueArray[++index] = i;
            tail++;
            realSize++;
        }
    }

    /**
     * 移除数据
     * 返回-1代表没有数据
     * @return
     */
    public int remove() {
        int n = -1;
        if (!isNull()) {
            //队列不为空
            n = QueueArray[head];
            QueueArray[head] = -1;
            //队头上移
            head++;
            //队头上移后等于数组最大长度，队头绕回去指向起始位置
            if (head == maxSize) {
                head = 0;
            }
            realSize--;
            return n;
        }
        return n;
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
    public int peekHead(){
        return  QueueArray[head];
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.insert(5);
        priorityQueue.insert(4);
        priorityQueue.insert(8);
        priorityQueue.insert(2);
        priorityQueue.insert(6);
        priorityQueue.insert(7);
        priorityQueue.insert(9);
        priorityQueue.remove();
        System.out.println(priorityQueue.peekHead());

    }
}
