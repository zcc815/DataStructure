package online.zcc815.huffmantree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Project  DataStructures
 * Package  online.zcc815.huffmantree
 *
 * @Description
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/10/21 21:04
 * @Version 1.0.0
 */
public class HuffManTree {

    public static void main(String[] args) {
        //创建霍夫曼树
        int arr[] = {13,7,8,3,29,6,1};
        Node root = createHuffManTree(arr);
        preOrder(root);

    }

    public static void preOrder(Node root) {
        if (root!= null){
            root.preOrder();
        }else{
            System.out.println("空树,无法遍历");
        }
    }

    public static Node createHuffManTree(int[] arr) {
        ArrayList<Node> nodes = new ArrayList<>();
        //遍历数组
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes);
            //取出权值最小的节点
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //构建一颗新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            //将前驱和后继节点指定
            parent.left=leftNode;
            parent.right=rightNode;
            //移除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将新生成的二叉树添加进去
            nodes.add(parent);
        }
        //将最顶层的节点返回(实际最后也就剩一个节点)
        return nodes.get(0);
    }
}

class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
