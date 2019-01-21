package com.java.structure.link;

import java.util.concurrent.BlockingDeque;

/**
 * 单向链表
 */
public class BaseLink {
    //根结点
    Node root;
    //链表长度
    int size;

    //初始化链表
    public BaseLink(Object s) {
        Node node = new Node(s);
        this.root = node;
        this.size = 0;
    }

    class Node{
        //结点数据
        Object data;
        //指向的下一个结点
        Node next;
        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     *  添加结点
     * @param s
     */
    public void insert(Object s){
        Node node = new Node(s);
        node.next = root;
        root = node;
        size++;
    }

    /**
     * 显示链表头的数据
     * @return
     */
    public Object peek(){
        return  root.data;
    }

    /**
     *  删除指定结点
     *  分成二步:
     *  1. 找到要删除的结点是否存在
     *  2. 如果找到就要删除的结点把该结点的上一个结点的指向改成该结点的下一个结点
     *
     */
    public Boolean delect(Object o){
        Node current = root;
        Node previous =root;
        while (current.next!=null){
            if(o.equals(current.data)){
                //找到要删除的结点了
                previous.next =current.next;
                return true;
            }else {
                previous = current;
                current = current.next;
            }
        }
        //没有找到要删除的结点
        return false;
    }

    /**
     * 删除头结点
     * @return
     */
    public Boolean delectRoot(){
        if(size==0){
            //链表长度为0
            return false;
        }
        root = root.next;
        return true;
    }

    /**
     * 显示结点所有元素
     */
    public void show(){
        Node node = root;
        while (true){
            System.out.print(node.data+"---");
            node =node.next;
            if(node==null){
                break;
            }
        }
    }

    /**
     * 判断链表是否为空
     * @return
     */
    public Boolean isNull(){
        if(size==0){
            return true;
        }else {
            return  false;
        }
    }

}
