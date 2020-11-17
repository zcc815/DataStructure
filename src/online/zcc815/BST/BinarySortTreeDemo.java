package online.zcc815.BST;

import jdk.nashorn.internal.ir.CallNode;

/**
 * Project  DataStructures
 * Package  online.zcc815.BST
 *
 * @Description
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/10/26 19:39
 * @Version 1.0.0
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int arr[] = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i : arr) {
            binarySortTree.addNode(new Node(i));
        }
        binarySortTree.infixOrder();
        binarySortTree.deleteNode(1);
        System.out.println("删除后");
        binarySortTree.infixOrder();
    }
}

//创建BST(二叉平衡树)
class BinarySortTree {
    Node root;

    public void addNode(Node node) {
        if (this.root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉平衡树为空");
        }
    }

    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环查找左子节点,就会找到最小值
        while (target.leftNode != null) {
            target = target.leftNode;
        }
        deleteNode(target.value);
        return target.value;
    }

    //删除节点
    public void deleteNode(int value) {
        if (root == null) {
            return;
        }
        Node targetNode = root.search(value);
        if (targetNode == null) {
            return;
        }
        //发现查找的树只有一个节点,root即为我们要删除的节点
        if (root.leftNode == null && root.rightNode == null) {
            root = null;
            return;
        }
        Node parentNode = root.searchParentNode(value);
        if (targetNode.leftNode == null && targetNode.rightNode == null) {
            //判断target为父节点的左子节点还是右子节点
            if (parentNode.leftNode != null && parentNode.leftNode.value == targetNode.value) {
                parentNode.leftNode = null;
            } else if (parentNode.rightNode != null && parentNode.rightNode.value == targetNode.value) {
                parentNode.rightNode = null;
            }
        } else if (targetNode.leftNode != null && targetNode.rightNode != null) {
            int treeMinVale = delRightTreeMin(targetNode.rightNode);
            targetNode.value = treeMinVale;
        } else {
            //删除只有一棵子树的节点
            //如果要删除的节点只有左子节点
            if (targetNode.leftNode != null) {
                if (parentNode.leftNode.value == value) {
                    parentNode.leftNode = targetNode.leftNode;
                } else {
                    parentNode.rightNode = targetNode.leftNode;
                }
            } else {
                //如果targetNode是parent的右子节点
                if (targetNode.leftNode != null) {
                    if (parentNode.leftNode.value == value) {
                        parentNode.leftNode = targetNode.rightNode;
                    } else {
                        parentNode.rightNode = targetNode.rightNode;
                    }
                }
            }
        }
    }
}

class Node {
    int value;
    Node leftNode;
    Node rightNode;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //添加节点的方法
    public void add(Node node) {
        //判断传入的节点的值是否为空
        if (node == null) {
            return;
        }
        //判断当前节点和node的值大小,大往右,小往左
        if (node.value <= this.value) {
            if (this.leftNode == null) {
                this.leftNode = node;
            } else {
                this.leftNode.add(node);
            }
        } else {
            if (this.rightNode == null) {
                this.rightNode = node;
            } else {
                this.rightNode.add(node);
            }
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.leftNode != null) {
            this.leftNode.infixOrder();
        }
        System.out.println(this);
        if (this.rightNode != null) {
            this.rightNode.infixOrder();
        }

    }

    //查找要删除的节点
    public Node search(int value) {
        //判断是否为当前节点
        if (value == this.value) {
            return this;
        } else {
            //判断是否在左子树中
            if (value < this.value && this.leftNode != null) {
                return this.leftNode.search(value);
                //判断是否在右子树中
            } else if (value > this.value && this.rightNode != null) {
                return this.rightNode.search(value);
                //都没找到
            } else {
                return null;
            }
        }
    }

    //查找要删除的父节点
    public Node searchParentNode(int value) {
        if ((this.leftNode != null && this.leftNode.value == value) || (this.rightNode != null && this.rightNode.value == value)) {
            return this;
        } else {
            if (this.leftNode != null && this.leftNode.value < value) {
                return this.leftNode.searchParentNode(value);
            } else if (this.rightNode != null && this.rightNode.value > value) {
                return this.rightNode.searchParentNode(value);
            } else {
                return null;
            }
        }
    }
}


