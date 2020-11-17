package online.zcc815.queue;

/**
 * Project  DataStructures
 * Package  online.zcc815.queue
 *
 * @Description 约瑟夫循环问题
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/6/20 22:39
 * @Version 1.0.0
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        System.out.println(circleSingleLinkedList.getLength());
        circleSingleLinkedList.query(1,2);
    }
}

class CircleSingleLinkedList {
    private Boy first = null;

    //增加节点
    public void addBoy(int nums) {
        //判断添加的数目是否合法
        if (nums < 1) {
            System.out.println("输入的数目不合法");
            return;
        }
        Boy curr = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            //第一个特殊对待
            if (i == 1) {
                first = boy;
                boy.setNext(first);
                curr = first;
            } else {
                curr.setNext(boy);
                boy.setNext(first);
                curr = boy;
            }
        }
    }

    //打印小孩的编号
    public void showBoy() {
        if (first.getNext() == null) {
            System.out.println("没有数据");
            return;
        }
        Boy curr = first;
        while (true) {
            System.out.printf("小孩的编号 %d \n", curr.getNo());

            if (curr.getNext() == first) {
                break;
            }
            curr = curr.getNext();
        }
    }

    //得到小孩的个数
    public int getLength() {
        if (first.getNext() == null) {
            System.out.println("小孩个数为0");
            return 0;
        }
        Boy curr = first;
        int count = 1;
        while (true) {
            if (curr.getNext() == first) {
                break;
            }
            count++;
            curr = curr.getNext();
        }
        return count;
    }

    public void query(int startNo, int count) {
        int length = getLength();
        if (count > length || startNo < 1) {
            System.out.println("输入的数不合法");
            return;
        }
        Boy curr = first;
        //curr应当指向最后一个节点
        while(true){
            if(curr.getNext() ==first){
                break;
            }
            curr=curr.getNext();
        }
        //让头节点指向开始的小孩
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            curr = curr.getNext();
        }
        while (true) {
            //当链表中滋生一个节点的时候就完成了任务
            if (curr == first) {
                break;
            }
            //找到要出圈的小孩
            for (int i = 0; i < count - 1; i++) {
                first = first.getNext();
                curr = curr.getNext();
            }
            System.out.println("出圈的小孩编号:\n" + first.getNo());
            first = first.getNext();
            curr.setNext(first);
        }
        System.out.println("最后留在圈中的小孩:\n" + curr.getNo());
    }
}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}