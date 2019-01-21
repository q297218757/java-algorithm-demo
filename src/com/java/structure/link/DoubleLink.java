package com.java.structure.link;

/**
 * 双向链表
 */
public class DoubleLink {
    //头结点
    Node head;
    //尾节点
    Node tail;
    //链表长度
    int size;
    //链表结点类
    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    /**
     * 判断链表是否为空链表
     * @return
     */
    public Boolean isNull(){
        if(size==0){
            //链表长度为空
            return true;
        }else {
//            /链表长度不为空
            return false;
        }
    }

    /**
     *  链表头添加数据
     * @param s
     */
    public void headInsert(Object s){
        Node node = new Node(s);
        if(isNull()){
            head = node;
            tail = node;
            size ++;
        }else {
            //链表头添加数据
            node.next = head;
            head = node;
            size++;
        }
    }

    /**
     * 链表尾添加数据
     * @param s
     */
    public void tailInsert(Object s){
        Node node = new Node(s);
        if(isNull()){
            head = node;
            tail = node;
        }else {
            tail.next =node;
            tail = node;
            size++;
        }
    }

    /**
     * 返回链表尾的数据
     */
    public Object reTail(){
        return  tail.data;
    }

    /**
     * 返回链表头的数据
     */
    public Object rehead(){
        return head.data;
    }

    /**
     * 删除链表头的数据
     * @return
     */
    public void delectHead(){
        if(isNull()){
            System.out.println("链表为空！！！");
        }else if(size==1){
            head = null;
            tail = null;
            size--;
        }else {
            head =head.next;
            size--;
        }
    }

    /**
     * 删除队尾的数据
     */
    public void delectTail(){
        if(isNull()){
            System.out.println("链表为空！！！");
        }else if(size==1){
            head = null;
            tail = null;
            size--;
        }else {
            tail =tail.next;
            size--;
        }
    }

    /**
     * 显示链表信息
     */
    public void show(){
       if(size>0){
           Node node = head;
           int tempSize =size;
           if(tempSize == 1){
               System.out.print("["+node.data+"]");
           }else {
               while(tempSize>0){
                    if(node==head){
                        //当前结点是头结点
                        System.out.print("["+node.data+"->");
                    }else if(node.next == null){
                        System.out.print(node.data+"]");
                    }else {
                        System.out.print(node.data+"->");
                    }
                    node = node.next;
                   tempSize--;
               }
               System.out.println("");
           }
       }else {
           System.out.println("[]");
       }
    }

    public static void main(String[] args) {
        DoubleLink doubleLink = new DoubleLink();
        doubleLink.headInsert("q");
        doubleLink.headInsert("w");
        doubleLink.headInsert("e");
        doubleLink.headInsert("r");
        doubleLink.tailInsert("u");
        doubleLink.tailInsert("o");
        doubleLink.tailInsert("p");
        doubleLink.show();
    }
}
