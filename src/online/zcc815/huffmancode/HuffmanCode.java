package online.zcc815.huffmancode;

import java.util.*;

/**
 * Project  DataStructures
 * Package  online.zcc815.sort
 *
 * @Description
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/10/25 16:50
 * @Version 1.0.0
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);
        List<Node> nodeList = getNodes(contentBytes);
        Node huffmanTree = createHuffmanTree(nodeList);
        huffmanTree.preOrder();
    }

    private static List<Node> getNodes(byte[] bytes) {
        ArrayList<Node> node = new ArrayList<Node>();
        //存放每个字符出现的次数
        HashMap<Byte, Integer> map = new HashMap<>();
        for (int i = 0; i < bytes.length; i++) {
            if (map.get(bytes[i]) == null) {
                map.put(bytes[i], 1);
            } else {
                map.put(bytes[i], map.get(bytes[i])+1);
            }
        }
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            node.add(new Node(entry.getKey(), entry.getValue()));
        }
        return node;
    }
    private static Node createHuffmanTree(List<Node> nodes){
        while(nodes.size() > 1){
            //排序
            Collections.sort(nodes);
            //取出最小的两颗二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //创建新的二叉树
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.leftNode = leftNode;
            parent.rightNode = rightNode;
            nodes.add(parent);
            nodes.remove(leftNode);
            nodes.remove(rightNode);
        }
        return nodes.get(0);
    }
    private static void preOrder(Node root){
        if (root!=null){
            root.preOrder();
        }else{
            System.out.println("霍夫曼树为空");
        }
    }
}


class Node implements Comparable<Node> {
    Byte data;
    int weight;
    Node leftNode;
    Node rightNode;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public Byte getData() {
        return data;
    }

    public void setData(Byte data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.leftNode != null) {
            this.leftNode.preOrder();
        }
        if (this.rightNode != null) {
            this.rightNode.preOrder();
        }
    }
}
