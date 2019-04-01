package com.java.structure.tree;

/**
 * 红黑树(数组实现)
 */
public class RedBlackTree {
    RBNode root ;

    class RBNode<T extends Comparable<T>>{
        boolean color; //true代表红色 false代表黑色
        T key;
        RBNode<T> left; //左结点
        RBNode<T> right; //右结点
        RBNode<T> parent; //父结点


        public RBNode(boolean color, T key, RBNode<T> left, RBNode<T> right, RBNode<T> parent) {
            this.color = color;
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public T getKey(){
            return this.key;
        }
        //打印结点的关键值和颜色信息
        public String toString(){
            return ""+key+(this.color == true ? "R":"B");
        }
    }

    /*************对红黑树结点x进行左旋操作 ******************/
    /*
     * 左旋示意图：对结点x进行左旋
     *     p                       p
     *    /                       /
     *   x                       y
     *  / \                     / \
     * lx  y      ----->       x  ry
     *    / \                 / \
     *   ly ry               lx ly
     * 左旋做了三件事：
     * 1. 将y的左子结点赋给x的右子结点,并将x赋给y左子结点的父结点(y左子结点非空时)
     * 2. 将x的父结点p(非空时)赋给y的父结点，同时更新p的子结点为y(左或右)
     * 3. 将y的左子结点设为x，将x的父结点设为y
     */
    private void leftRotate(RBNode x){
        //1. 将y的左子结点赋给x的右子结点，并将x赋给y左子结点的父结点(y左子结点非空时)
        RBNode y = x.right;
        x.right = y.left;
        if(y.left != null){
            y.left.parent = x;
        }

        //2. 将x的父结点p(非空时)赋给y的父结点，同时更新p的子结点为y(左或右)
        y.parent = x.parent;
        if(x.parent == null){
            this.root = y;//如果x的父结点为空(即x为根结点)，则将y设为根结点
        }else{
            if(x == x.parent.left){//如果x是左子结点
                x.parent.left = y;//则也将y设为左子结点
            }else{
                x.parent.right = y;//否则将y设为右子结点
            }
        }

        //3. 将y的左子结点设为x，将x的父结点设为y
        y.left = x;
        x.parent = y;
    }

    /*************对红黑树结点y进行右旋操作 ******************/
    /*
     * 左旋示意图：对结点y进行右旋
     *        p                   p
     *       /                   /
     *      y                   x
     *     / \                 / \
     *    x  ry   ----->      lx  y
     *   / \                     / \
     * lx  rx                   rx ry
     * 右旋做了三件事：
     * 1. 将x的右子结点赋给y的左子结点,并将y赋给x右子结点的父结点(x右子结点非空时)
     * 2. 将y的父结点p(非空时)赋给x的父结点，同时更新p的子结点为x(左或右)
     * 3. 将x的右子结点设为y，将y的父结点设为x
     */
    private void rightRotate(RBNode y){
        //1. 将y的左子结点赋给x的右子结点，并将x赋给y左子结点的父结点(y左子结点非空时)
        RBNode x = y.left;
        y.left = x.right;
        if(x.right != null){
            x.right.parent = y;
        }

        //2. 将x的父结点p(非空时)赋给y的父结点，同时更新p的子结点为y(左或右)
        x.parent = y.parent;
        if(y.parent == null){
            this.root = x;//如果y的父结点为空(即y为根结点)，则旋转后将x设为根结点
        }else{
            if(y == y.parent.left){//如果y是左子结点
                y.parent.left = x;//则将x也设置为左子结点
            }else{
                y.parent.right = x;//否则将x设置为右子结点
            }
        }

        //3. 将x的左子结点设为y，将y的父结点设为y
        x.right = y;
        y.parent = x;
    }

    /*********************** 向红黑树中插入结点 **********************/
    public void insert(int key){
        RBNode node = new RBNode(true, key, null, null, null);
        if(node != null){
            insert(node);
        }
    }
    public void insert(RBNode<Integer> node){
        RBNode<Integer> current = null;//表示最后node的父结点
        RBNode<Integer> x = this.root;//用来向下搜索

        //1.找到插入位置
        while(x != null){
            current = x;
            int cmp = node.key.compareTo(x.key);
            if(cmp < 0){
                x = x.left;
            }else{
                x = x.right;
            }
        }
        node.parent = current;//找到了插入的位置，将当前current作为node的父结点

        //2.接下来判断node是左子结点还是右子结点
        if(current != null){
            int cmp = node.key.compareTo(current.key);
            if(cmp < 0){
                current.left = node;
            }else{
                current.right = node;
            }
        }else{
            this.root = node;
        }

        //3.利用旋转操作将其修正为一颗红黑树
        insertFixUp(node);
    }

    /**
     * 红黑树修正方法
     * @param node
     */
    private void insertFixUp(RBNode node){
        RBNode parent,gparent;//定义父结点和祖父结点

        //需要修正的条件：父结点存在，且父结点的颜色是红色
        while(((parent = parentOf(node)) != null) && isRed(parent)){
            gparent = parentOf(parent);//获得祖父结点

            //若父结点是祖父结点的左子结点，下面的else相反
            if(parent == gparent.left){
                RBNode uncle = gparent.right;//获得叔叔结点

                //case1:叔叔结点也是红色
                if(uncle != null && isRed(uncle)){
                    setBlack(parent);//把父结点和叔叔结点涂黑
                    setBlack(uncle);
                    setRed(gparent);//把祖父结点涂红
                    node = gparent;//把位置放到祖父结点处
                    continue;//继续while循环，重新判断
                }

                //case2:叔叔结点是黑色，且当前结点是右子结点
                if(node == parent.right){
                    leftRotate(parent);//从父结点出左旋
                    RBNode tmp = parent;//然后将父结点和自己调换一下，为下面右旋做准备
                    parent = node;
                    node = tmp;
                }

                //case3:叔叔结点是黑色，且当前结点是左子结点
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
            }else{//若父结点是祖父结点的右子结点，与上面的情况完全相反，本质是一样的
                RBNode uncle = gparent.left;

                //case1:叔叔结点也是红色的
                if(uncle != null && isRed(uncle)){
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }

                //case2:叔叔结点是黑色的，且当前结点是左子结点
                if(node == parent.left){
                    rightRotate(parent);
                    RBNode tmp = parent;
                    parent = node;
                    node = tmp;
                }

                //case3:叔叔结点是黑色的，且当前结点是右子结点
                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);
            }
        }
        setBlack(root);//将根结点设置为黑色
    }

    private RBNode parentOf(RBNode rbNode){
        return rbNode.parent;
    }

    private boolean isRed(RBNode rbNode){
        return rbNode.color;
    }
    private boolean isBlack(RBNode rbNode){
        return !rbNode.color;
    }

    private void setRed(RBNode rbNode){
        rbNode.color =true;
    }
    private void setBlack(RBNode rbNode){
        rbNode.color =false;
    }

    public static void main(String[] args) {
        RedBlackTree RBNode = new RedBlackTree();
        RBNode.insert(11);
        RBNode.insert(7);
        RBNode.insert(14);
        RBNode.insert(2);
        RBNode.insert(1);
        RBNode.insert(15);
        RBNode.insert(5);
        RBNode.insert(8);
        RBNode.insert(4);
    }

}
