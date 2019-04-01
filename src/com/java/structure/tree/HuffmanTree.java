package com.java.structure.tree;

import com.java.sort.senior.QuickSort;

import java.util.ArrayList;
import java.util.List;

/**
 *   哈夫曼树
 *   定义：给定n个权值作为n个叶子结点，构造一棵二叉树，若树的带权路径长度达到最小，则这棵树被称为哈夫曼树
 *          180
 *        /   \
 *     100    80
 *           / \
 *         50  30
 *           /  \
 *         20    10
 *
 *  带权路径长度(WPL) = 100*1 + 50*2 +20*2 +10*2 = 290
 *  上图的树为权值100,50,20,10的哈夫曼树
 *
 *  哈夫曼树构造规则为：
 *  1. 将w1、w2、…，wn看成是有n 棵树的森林(每棵树仅有一个结点)；
 * 2. 在森林中选出根结点的权值最小的两棵树进行合并，作为一棵新树的左、右子树，且新树的根结点权值为其左、右子树根结点权值之和；
 * 3. 从森林中删除选取的两棵树，并将新树加入森林；
 * 4. 重复(02)、(03)步，直到森林中只剩一棵树为止，该树即为所求得的哈夫曼树。
 */
public class HuffmanTree {
    //跟节点
    Node root;
    //树的实际大小
    private int size = 0;

    //哈夫曼树结点
    public class Node{
        int weight; //权值
        Node left;  //左结点
        Node right; //右结点

        public Node(int weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    ", weight=" + weight +
                    '}';
        }
    }

    //给权的权值排序(快速排序)
    private   List<Node> sort(List<Node> Nodes){
        QuickSort quickSort = new QuickSort();
        List<Integer> list = new ArrayList<>();
        for (Node node:Nodes){
            list.add(node.weight);
        }
        List<Integer> list1 =  quickSort.sort(list);
        return Nodes;
    }

    public List<Node> m(List<Node> nodes){
        nodes = sort(nodes);
        if( nodes.size() == 1){
           return nodes;
        }else {
            nodes.add(merge(nodes.get(0),nodes.get(1)));
            nodes.remove(0);
            nodes.remove(0);
            return  m(nodes);
        }

    }

    //两个节点结合成一棵树
    private Node  merge(Node left,Node right){
        Node node = new Node(left.weight+right.weight);
        node.left = left;
        node.right = right;
        return node;
    }

    public  void test() {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(15));
        nodes.add(new Node(6));
        nodes.add(new Node(5));
        nodes.add(new Node(8));
        nodes.add(new Node(7));
        List list = m(nodes);
    }

    public static void main(String[] args) {
        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.test();
    }
}


