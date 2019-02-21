package com.java.structure.tree;

/**
 *  有序二叉树
 *  一个结点的值比左子结点的值大，比右子结点的值小
 */
public class TwoForkTree {
    //根结点
    private Node root;
    //二叉树的结点类
    class Node{
        private int data;
        private Node leftNode;
        private Node rightNode;

        public Node(int data) {
            this.data = data;
        }

        //打印结点的数据
        public void display(){
            System.out.println(this.data);
        }
    }

    /**
     * 往树中插入数据
     * 插入数据分为以下三步
     * 1. 判断根结点是够为空
     * 2. 判断要插入的树和根结点的大小，如果大于就往右边找子结点，小于就往左边找子结点
     * 3. 如果到当前结点的子结点为空，根据大小比较插入数据
     * @param o
     */
    public  Boolean insert (int o){
        Node node = new Node(o);
        if(root ==null){
            root = node;
        }else {
           Node current = root;
           Node previous = current;
           while (current!=null){
               if(o>current.data){
                   previous = current;
                   //插入的数据比该结点的值大，找该结点的右子结点
                   current = current.rightNode;
                   if(current==null){
                       previous.rightNode =node;
                       return true;
                   }
               }else if (o< current.data){
                   previous = current;
                   //插入的数据比该结点的值小,找改结点的左子结点
                   current =current.leftNode;
                   if(current==null){
                       previous.leftNode =node;
                       return true;
                   }
               }else {
                   //排序二叉树中已经有这个值了
                   System.out.println("排序二叉树中已经存在该值");
                   return  false;
               }
           }
        }
        return false;
    }
    /*
    判断树是否为空
     */
    public Boolean isNull(){
        if(root==null){
            return false;
        }
        return true;
    }

    /*
        查找最小值
     */
    public int selectMin(){
        Node current = root;
        Node previous = root;
        while (current!=null){
                previous = current;
                current = current.leftNode;
        }
        return previous.data;
    }

    /*
    查找最大值
     */
    public int selectMax(){
        Node current = root;
        Node previous = root;
        while (current!=null){
            previous = current;
            current = current.rightNode;
        }
        return previous.data;
    }
    /*
    前序遍历
     */
    public void frontOrder(Node node){
       if (node != null) {
           System.out.println(node.data);
           frontOrder(node.leftNode);
           frontOrder(node.rightNode);
       }
    }
    /*
    中序遍历
     */
    public void middleOrder(Node node){
        if(node != null){
            middleOrder(node.leftNode);
            System.out.println(node.data);
            middleOrder(node.rightNode);

        }
    }
    /*
    后序遍历
     */
    public void afterOrder(Node node){
       if(node != null){
           afterOrder(node.leftNode);
           afterOrder(node.rightNode);
           System.out.println(node.data);
       }
    }
    /*
    删除结点是二叉搜索树中最复杂的操作，删除的结点有三种情况，前两种比较简单，但是第三种却很复杂。
    1、该结点是叶结点（没有子结点）
    2、该结点有一个子结点
    3、该结点有两个子结点
    删除结点分为三步
    1.找到要删除的结点
    2.判断要删除的结点属于哪种情况
    3.删除结点
     */
    public Boolean delect(int data){
        Node current= root; //当前结点
        Node previous = root; //上一个结点
        //该结点是叶结点（没有子结点）
        if(root ==null){
            return  false;
        }else {
            //查找要删除的结点
            while (current!=null){
                if(current.data ==data){
                    //找到值了
                    break;
                }else {
                    if(data>current.data){
                        //查找的结点大于当前结点，往右子树遍历
                        previous = current;
                        current = current.rightNode;
                    }else {
                        //查找的结点大于当前结点，左子树遍历
                        previous = current;
                        current = current.leftNode;
                    }
                }
            }
        }
         // 1、该结点是叶结点（没有子结点）
        if(current.rightNode==null && current.leftNode==null){
            if(current.data>previous.data){
                previous.rightNode = null;
            }else {
                previous.leftNode = null;
            }
        }
        // 2、该结点有一个子结点
        //左结点为空，右结点不为空
        if(current.leftNode == null&& current.rightNode != null) {
            if(current == root ){
                root = current.rightNode;
            }else {
                if (current.data > previous.data) {
                    previous.rightNode = current.rightNode;
                } else {
                    previous.leftNode = current.rightNode;
                }
            }
        }
        //左结点不为空，右结点为空
        if(current.leftNode != null&& current.rightNode == null){
            if(current == root){
                root = current.leftNode;
            }else {
                if (current.data > previous.data) {
                    previous.rightNode = current.leftNode;
                } else {
                    previous.leftNode = current.leftNode;
                }
            }
        }
        /**
         * 3、该结点有两个子结点
         * 要删除的结点有两个结点，所以删除之后需要找一个结点来替换他。
         * 这个替换的结点称为后继结点，因为有二叉树是有序的，所以得出
         * 后继结点也就是：比删除结点大的最小结点。
         * 找到后继结点的具体方法：
         * 1.找到要删除结点的右结点1
         * 2.遍历结点1的左结点，当遍历到左结点为空，该结点就是后继结点
         */

        if(current.rightNode!=null && current.leftNode !=null){
            //1.找到要删除结点的右结点1
            Node inNode = current.rightNode; //后继结点
            Node preiNode = inNode; //后继结点的父结点
            while (inNode.leftNode!=null){
                preiNode = inNode;
                inNode = inNode.leftNode;
            }
            //后继结点不是要删除的结点的右结点
            if(current.rightNode != inNode){
                //判断要删除的结点是左结点还是右结点
                if (current.data > previous.data) {
                    previous.rightNode = inNode;
                    preiNode.leftNode = inNode.rightNode;
                    inNode.rightNode =current.rightNode;
                } else {
                   previous.leftNode = inNode;
                   preiNode.leftNode = inNode.rightNode;
                   inNode.rightNode = current.rightNode;
                }
            }else {
                //判断要删除的结点是左结点还是右结点
                if (current.data > previous.data) {
                    previous.rightNode = inNode;
                } else {
                    previous.leftNode = inNode;
                }
            }
            inNode.leftNode = current.leftNode;
        }
        return true;
    }

    /*
    查找指定的值
     */
    public Boolean select(int data){
        if(root ==null){
            return  false;
        }else {
            Node current = root;
            Node previous = current;
            while (current!=null){
                if(current.data ==data){
                    //找到值了
                    return true;
                }else {
                    if(data>current.data){
                        previous = current;
                        current = current.rightNode;
                    }else {
                        previous = current;
                        current = current.leftNode;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        TwoForkTree twoForkTree = new TwoForkTree();
        twoForkTree.insert(20);
        twoForkTree.insert(10);
        twoForkTree.insert(9);
        twoForkTree.insert(15);
        twoForkTree.insert(16);
        twoForkTree.insert(14);
        twoForkTree.insert(12);
        twoForkTree.insert(13);
        twoForkTree.insert(35);
        twoForkTree.insert(34);
        twoForkTree.insert(40);
        twoForkTree.insert(45);
        twoForkTree.insert(39);
        twoForkTree.insert(36);
        twoForkTree.insert(38);
        twoForkTree.delect(35);
       //twoForkTree.frontOrder(twoForkTree.root);
       //twoForkTree.afterOrder(twoForkTree.root);
       //twoForkTree.middleOrder(twoForkTree.root);
       //System.out.println(twoForkTree.selectMin());
        twoForkTree.middleOrder(twoForkTree.root);
    }
}
