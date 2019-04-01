package com.java.structure.heap;

import java.util.Random;

/**
 * 温馨提示：反人类的实现，千万别碰，谁碰谁死
 * 腰斩了，只有插入没有删除了，以后想不开再回来写
 *
 * 堆(前后指针的链表实现)
 * 链表实现堆的特点:
 *  1.结点的左子结点是 2*index+1，
 *  2.结点的右子结点是 2*index+2
 *
 * 链表实现堆的优点：
 * 1.无长度上限，需要的时候再申请分配内存空间，可最大程度上实现灵活性。
 * 缺点：
 * 1.链式结构的链接字段需要消耗一定的内存
 * 3.在链式结构中访问一个特定元素的效率不如数组。
 */
public class LinkHeap {
    //链表头结点
    private Node head;
    //链表尾节点
    private  Node tail;
    //堆真实大小
    private int cuurentSize;

    //结点
    private class Node{
        int position;
        int idata;
        Node nextNode;
        Node frontNode;

        public Node(int idata,int position) {
            this.idata = idata;
            this.position = position;
        }
    }

    //判断堆是否为空
    public Boolean empty(){
        if(cuurentSize != 0){
            return false;
        }else {
            return true;
        }
    }

    //插入数据
    public void insert(int data){
        //初始化一个结点
        Node node = new Node(data,cuurentSize);
        if(empty()){
            head = node;
            tail = node;
            cuurentSize++;
        }else {
            tail.nextNode = node;
            node.frontNode = tail;
            tail = node;
            cuurentSize++;
            trickleUp(node);
        }
    }

    //删除数据
    public void remove(int data){

    }
    /**
     * 向上调整(新增时需要向上调整，让当前插入的结点上移到最大的小于他的二结点之前)
     * 注意：向上筛选和向下不同，向上筛选只用和一个父结点进行比较，比父结点小就停止筛选了
     * @param node
     */
    private  void trickleUp(Node node){
        int parentPosition = (node.position-1)/2;//父结点的位置
        int time = node.position - parentPosition; //迁移的次数
        Node parent = node;
        for (int i = 0;i<time;i++){
            parent = parent.frontNode;
        }
        while (node.position > 0 && node.idata > parent.idata){
            Node parentf = parent.frontNode; //父结点的前一个结点
            Node parentn = parent.nextNode; //父结点的后一个结点
            Node nodef = node.frontNode;  //当前结点的前一个结点
            Node noden = node.nextNode;  //当前结点的后一个结点

            //父结点非根节点
            if(parent != head){
                parentf.nextNode = node;
            }else {
                head = node;
            }
            if(node != tail){
            //当前结点不是尾节点
                noden.frontNode = parent;
           }else {
                tail = parent;
            }
            //该结点不是根节点的左结点
            if(node.position != 1) {
                nodef.nextNode = parent;
                parentn.frontNode = node;
                node.nextNode = parentn;
                parent.frontNode = nodef;
            }else {
                //该结点的是根节点的左结点
                node.nextNode = parent;
                parent.frontNode = node;
            }

            //父子节点本身的变更
            node.frontNode = parentf;
            parent.nextNode = noden;
            //父子的位置标识交换
            parent.position = node.position;
            node.position = parentPosition;

            //父子结点换位
            parent = node;
            //找到父结点
            parentPosition = (node.position-1)/2;//父结点的位置
            time = node.position - parentPosition;//迁移的次数
            for (int i = 0;i<time;i++){
                parent = parent.frontNode;
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        LinkHeap heap = new LinkHeap();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            heap.insert(random.nextInt(9999999)+1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("运行时间:" + (endTime - startTime) + "ms");
    }
}
