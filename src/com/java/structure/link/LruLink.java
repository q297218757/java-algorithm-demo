package com.java.structure.link;

/**
 * lru算法（淘汰最近最少使用）
 */
public class LruLink {
    private Node head; //头结点
    private Node tail; //尾节点
    private static int size = 0; //实际大小
    private final int capacity; //最大容积

    public LruLink(int n) {
        capacity = n;
    }

    class Node {
        private Object data;
        private Node next;
        private Node front;

        public Node(Object data) {
            this.data = data;
        }
    }

    private void insert(Node node) {
        Node temp;
        if (size == 0) {
            //链表为空
            head = node;
            tail = node;
            size++;
        } else if (capacity > size) {
            if (!search(node)) {
                //链表没满
                temp = head;
                head.front = node;
                head = node;
                node.next = temp;
                size++;
            }
        } else {
            if (!search(node)) {
                //没有找到对应的元素，需要淘汰元素
                temp = head;
                head.front = node;
                head = node;
                node.next = temp;
                tail.front.next = null;
                tail = tail.front;
            }
        }
    }

    private boolean search(Node node) {
        Node current = head;
        boolean flag = false;
        //链表满了，需要淘汰
        while (current != null) {
            if (current.data.equals(node.data)) {
                //找到队列中存在的元素了
                if (current != head) {
                    if (current != tail) {
                        //相同点不是尾节点
                        current.next.front = current.front;
                    } else {
                        //相同点是尾节点(需要改变尾节点的指向)
                        tail = current.front;
                    }
                    current.front.next = current.next;
                    current.front = null;
                    head.front = current;
                    current.next = head;
                    head = current;
                    flag = true;
                }
                break;
            } else {
                current = current.next;
            }
        }
        return flag;
    }

    public void update(Object o) {
        Node node = new Node(o);
        insert(node);
    }

    public static void main(String[] args) {
        LruLink lruLink = new LruLink(3);
        lruLink.update("a");
        lruLink.update("b");
        lruLink.update("c");
        lruLink.update("d");
        lruLink.update("b");
        lruLink.update("c");
        lruLink.update("e");
    }
}
