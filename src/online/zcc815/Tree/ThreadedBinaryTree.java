package online.zcc815.Tree;

/**
 * Project  DataStructures
 * Package  online.zcc815.Tree
 *
 * @Description
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/10/19 20:03
 * @Version 1.0.0
 */
public class ThreadedBinaryTree {
    public static void main(String[] args) {
        HeroNode1 root = new HeroNode1(1, "zcc");
        HeroNode1 node2 = new HeroNode1(2, "xmw");
        HeroNode1 node3 = new HeroNode1(3, "gjh");
        HeroNode1 node4 = new HeroNode1(4, "lbq");
        HeroNode1 node5 = new HeroNode1(5, "wyp");
        HeroNode1 node6 = new HeroNode1(6, "zf");
        BinaryTree1 tree1 = new BinaryTree1();
        tree1.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        tree1.threadNodes();
        HeroNode1 left = node5.getLeft();
        HeroNode1 right = node5.getRight();
        System.out.println(left);
    }
}

class BinaryTree1 {
    private HeroNode1 root;
    private HeroNode1 pre = null;

    public void setRoot(HeroNode1 root) {
        this.root = root;
    }

    /**
     * 当前需要线索化得节点
     */
    public void threadNode(HeroNode1 node1) {
        if (node1 == null) {
            return;
        }
        //先线索化左子树
        threadNode(node1.getLeft());
        //线索化当前子树
        if (node1.getLeft() == null) {
            node1.setLeft(pre);
            node1.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node1);
            pre.setRightType(1);
        }
        pre = node1;
        //线索化右子树
        threadNode(node1.getRight());


    }
    public void threadNodes(){
        this.threadNode(root);
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }
    }

    //中序遍历
    public void midOrder() {
        if (this.root != null) {
            this.root.midOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }
    }

    //删除节点
    public void deleteHeroNode(int no) {
        //判断当前数是否为null
        if (this.root == null) {
            System.out.println("当前数树为空,无法删除");
            return;
        }
        //判断要删除的节点是否为根节点
        if (this.root.getNo() == no) {
            this.root = null;
            return;
        }
        this.root.deleteHeroNode(no);
    }


}

class HeroNode1 {
    private int no;
    private String name;
    private HeroNode1 left;
    private HeroNode1 right;
    private int leftType;


    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getLeftType() {
        return leftType;
    }

    public int getRightType() {
        return rightType;
    }

    private int rightType;

    public HeroNode1(int no, String name) {
        super();
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode1 getLeft() {
        return left;
    }

    public void setLeft(HeroNode1 left) {
        this.left = left;
    }

    public HeroNode1 getRight() {
        return right;
    }

    public void setRight(HeroNode1 right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HearNode{" +
                "no=" + no +
                ", name='" + name +
                '}';
    }

    //前序遍历法
    public void preOrder() {
        System.out.println(this);
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历法
    public void midOrder() {
        //向左递归
        if (this.left != null) {
            this.left.midOrder();
        }
        //输出父节点
        System.out.println(this);
        //向右递归
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    //后序遍历法
    public void postOrder() {
        //向左递归遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        //向右递归遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        //输出父节点
        System.out.println(this);
    }

    public void deleteHeroNode(int no) {
        if (this.left != null) {
            if (this.left.getNo() == no) {
                this.left = null;
                return;
            }
            this.left.deleteHeroNode(no);
        }
        //递归向右子树遍历
        if (this.right != null) {
            if (this.right.getNo() == no) {
                this.right = null;
                return;
            }
            this.right.deleteHeroNode(no);
        }
    }
}