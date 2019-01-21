package com.java.structure.heap;

/**
 *  基本的堆（用数组来实现）
 *  堆就是完全二叉树，除了最后一层一一定要满
 *  堆是若排序的，不支持遍历
 *  用数组实现堆的几个特性：
 *  1.结点的左子结点是 2*index+1，
 *  2.结点的右子结点是 2*index+2，
 *  3. 结点的父结点是 （index-1）/2
 *  4.堆中的每一个结点的关键字都大于（或等于）这个结点的子结点的关键字。
 */
public class BaseHeap {
    //实现堆的数组
    private Node[] heapArray;
    // 堆的最大大小
    private int maxSize;
    //实际的最大容量
    private int currentSize;

    public BaseHeap(int maxSize) {
        heapArray = new Node[maxSize];
        this.maxSize = maxSize;
        currentSize = 0;
    }

    /**
     *  堆是否为空
     * @return
     */
    public Boolean isNull(){
        return (currentSize==0);
    }

    /**
     * 堆是否已经满了
     */
    public Boolean isFull(){
        return (currentSize==maxSize);
    }

    /**
     * 往堆里面添加数据
     * 往堆里面插入数据需要向上调整
     * @param idata
     */
    public Boolean insert(int idata){
        if(isFull()){
            //堆满了
            System.out.println("堆满了");
            return false;
        }else {
            Node node = new Node(idata);
            heapArray[currentSize] = node;
            trickleUp(currentSize++);
            return true;
        }

    }
    /**
     * 向上调整(新增时需要向上调整，让当前插入的结点上移到最大的小于他的二结点之前)
     * 注意：向上筛选和向下不同，向上筛选只用和一个父结点进行比较，比父结点小就停止筛选了
     * @param index
     */
    public void trickleUp(int index){
        int parent =(index-1)/2; //父结点的索引
        Node bottom = heapArray[index]; //将新加入的尾结点存在bottom中;
        /*
           两个条件
           1.index>0代表存在父结点
           2.heapArray[parent].getiData() < bottom.getiData()代表新插入的数比父结点的数要大
         */
        while (index>0&&heapArray[parent].getiData() < bottom.getiData()){
            heapArray[index] = heapArray[parent];
            index = parent; //结点位置上移
            parent = (parent - 1) / 2;//找到上移后的结点的父结点
        }
        heapArray[index] = bottom; //找到合适的位置了
    }

    /**
     * 移除数据
     * 移除是指删除关键字最大的结点（或最小），也就是根结点。
     * ①、移走根
     * ②、把最后一个结点移动到根的位置
     * ③、一直向下筛选这个结点，直到它在一个大于它的结点之下，小于它的结点之上为止。
     */
    public Node remove() {
        Node root = heapArray[0];
        //把根结点的值变成最后一个结点的值
        heapArray[0] = heapArray[--currentSize];
        //移除了最大值，需要找到一个原来第二大的值放在根结点
        trickDowm(0);
        return root;
    }
    /**
     * 向下调整(删除时需要向下调整，把删除原最大结点后移动到子结点的结点的合适的位置)
     * 注意：向下筛选的时候，将目标结点和其子结点比较，谁大就和谁交换位置。
     * @param index
     */
    public void trickDowm(int index){
        //删除头结点后移动到根结点的数据
        Node top =heapArray[index];
        int largeChildIndex;
        while (index<currentSize/2){
            //结点至少有一个子结点
            int leftChildIndex =2*index+1; //左子结点
            int rightChildIndex  =leftChildIndex+1; //右子结点
            if(rightChildIndex < currentSize && //右子结点等于空
                    heapArray[leftChildIndex].getiData() < heapArray[rightChildIndex].getiData()){
                //右子结点大于左结点
                largeChildIndex = rightChildIndex;
            }else {
                //左子结点大于右子结点
                largeChildIndex = leftChildIndex;
            }

            if(top.getiData() >= heapArray[largeChildIndex].getiData()) {
                break;
            }
            heapArray[index] = heapArray[largeChildIndex];
            index = largeChildIndex;
        }
            heapArray[index] = top;
    }
    class Node{
        private int iData;

        public Node(int iData) {
            this.iData = iData;
        }

        public void setiData(int iData) {
            this.iData = iData;
        }

        public int getiData() {
            return iData;
        }
    }

    public static void main(String[] args) {
        BaseHeap baseHeap = new BaseHeap(10);
        baseHeap.insert(34);
        baseHeap.insert(68);
        baseHeap.insert(43);
        baseHeap.insert(55);
        baseHeap.insert(10);
        baseHeap.insert(78);
        baseHeap.remove();
        baseHeap.insert(82);


    }
}
