package algorithm.foroffer;

/**
 * Created by liyazhou on 2017/5/28.
 * 面试题27：二叉搜索树和双向链表
 *
 * 题目：
 *      输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *      要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *      比如输入下图中左边的二叉搜索树，则输出转换之后的排序双向链表。
 *
 *                      10
 *                    /    \
 *                  6       14
 *                /  \     /  \
 *               4    8   12  16
 *
 *        4 === 6 === 8 === 10 === 12 === 14 === 16
 *
 *  问题：
 *          1. 中序遍历二叉树
 *
 *  思路:
 *          1. 按书本C语言代码实现，感觉到很绕，没搞明白，需要继续思考
 */

class BinTreeNode{
    int value;
    BinTreeNode left;
    BinTreeNode right;
    public BinTreeNode(int value){ this.value = value; }
    public void setChildren(BinTreeNode left, BinTreeNode right){
        this.left = left;
        this.right = right;
    }
}


public class Test27 {

    public BinTreeNode convert(BinTreeNode root){
        BinTreeNode[] tailNode = new BinTreeNode[1];
        convert(root, tailNode);

        // tailNode 指向双向链表的尾结点，将其移动到头结点的位置
        BinTreeNode head = tailNode[0];
        for (; head != null && head.left != null; head = head.left);
        return head;

    }

    private void convert(BinTreeNode currNode, BinTreeNode[] tailNode){
        if (currNode == null) return;

        if (currNode.left != null) convert(currNode.left, tailNode);

        currNode.left = tailNode[0];

        if (tailNode[0] != null) tailNode[0].right = currNode;

        tailNode[0] = currNode;

        if (currNode.right != null) convert(currNode.right, tailNode);

    }

    public static void main(String[] args){
        BinTreeNode node0 = new BinTreeNode(10);
        BinTreeNode node1 = new BinTreeNode(6);
        BinTreeNode node2 = new BinTreeNode(14);
        BinTreeNode node3 = new BinTreeNode(4);
        BinTreeNode node4 = new BinTreeNode(8);
        BinTreeNode node5 = new BinTreeNode(12);
        BinTreeNode node6 = new BinTreeNode(16);

        node0.setChildren(node1, node2);
        node1.setChildren(node3, node4);
        node2.setChildren(node5, node6);

        BinTreeNode head = new Test27().convert(node0);
        System.out.println(head);
        for(; head != null; head = head.right)
            System.out.print(head.value + " -- ");
    }
}
