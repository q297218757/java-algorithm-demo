package com.java.structure.tree;

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

    //哈夫曼树结点
    public class Node{
        String name;
        double weight;
        Node left;
        Node right;

        public Node(String name, double weight) {
            this.name = name;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

    public void sort(List<Node> Nodes){
        
    }
}


