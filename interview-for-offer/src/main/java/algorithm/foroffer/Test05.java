package algorithm.foroffer;

import java.util.Stack;

/**
 * Created by liyazhou on 2017/5/23.
 * 面试题5：从尾到头打印链表
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值（不能改变链表的结构，仅仅对链表进行只读操作）
 */

class Node{
    private int value;
    private Node nextNode;

    public Node(){}
    public Node(int value){ this.value = value; }
    public Node(int value, Node nextNode){
        this.value = value;
        this.nextNode = nextNode;
    }

    public int getValue(){ return this.value; }
    public Node nextNode(){ return this.nextNode; }
    public void setNextNode(Node node){ this.nextNode = node; }
}

public class Test05 {

    /**
     * 方法一：使用栈
     * 思路：
     *      首先，遍历链表，将链表中的元素存入到栈中
     *      然后，访问栈中的元素
     * @param headNode 头结点
     */
    public static void printListReverselyUsingIteration(Node headNode){
        if (headNode == null) return;

        Stack<Node> stack = new Stack<>();
        while(headNode != null){
            stack.push(headNode);
            headNode = headNode.nextNode();
        }

        while(!stack.isEmpty()){
            Node currNode = stack.pop();
            System.out.print(String.format("%s \t", currNode.getValue()));
        }
    }


    /**
     * 方法二：递归，递归的本质就是栈结构，代码更加简洁
     * 思路：
     *      每访问到一个结点的时候，先递归输出它后面的结点，在输出该结点自身。
     * @param headNode 头结点
     */
    public static void printListReverselyUsingRecursion(Node headNode){
        if (headNode.nextNode() != null){
            printListReverselyUsingRecursion(headNode.nextNode());
        }
        System.out.print(String.format("%s \t", headNode.getValue()));

    }

    public static void main(String[] args){
        Node nextNode = new Node(1);
        Node headNode = new Node(0, nextNode);
        for(int i = 2; i < 10; i++){
            Node node = new Node(i);
            nextNode.setNextNode(node);
            nextNode = node;
        }

        Test05.printListReverselyUsingIteration(headNode);
        System.out.println();
        Test05.printListReverselyUsingRecursion(headNode);

    }
}
