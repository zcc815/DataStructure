package online.zcc815.queue;

import java.util.Scanner;

/**
 * Project  DataStructures
 * Package  online.zcc815.queue
 *
 * @Description 循环队列
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/6/2 22:12
 * @Version 1.0.0
 */
public class CycleQueueForArr {
    public static void main(String[] args) throws Exception {
        //创建循环队列类
        CycleQueue cycleQueue = new CycleQueue(5);//有效数据为4个
        Scanner scanner = new Scanner(System.in);
        String key = "";
        boolean flag = true;
        while (flag) {

            System.out.println("a:添加数据");
            System.out.println("b:取出数据");
            System.out.println("c:得到有效数据的个数");
            System.out.println("d:打印数据");
            System.out.println("q:退出");
            key = scanner.next();
            switch (key) {
                case "a":
                    System.out.println("请输入一个数");
                    cycleQueue.addData(scanner.nextInt());
                    break;
                case "b":
                    System.out.println("取出头部数据");
                    System.out.println("头部数据为" + cycleQueue.getData());
                    break;
                case "c":
                    cycleQueue.getValidData();
                    break;
                case "d":
                    cycleQueue.printData();
                    break;
                case "q":
                    flag = false;
                    break;
                default:
                    break;
            }
        }

    }
}

class CycleQueue {
    //创建头节点
    private int headPointer;
    //创建尾节点
    private int tailPointer;
    //创建数组保存数据
    private int[] arrForQueue;
    //创建队列容量指示器
    private int maxSize;
    //记录队列中有效数据的个数
    private int validData;

    //构造器
    public CycleQueue(int maxSize) {
        this.maxSize = maxSize;
        headPointer = 0;
        tailPointer = 0;
        validData = 0;
        arrForQueue = new int[maxSize];
    }

    //判断队列是否已满
    public boolean isFull() {
        return (tailPointer + 1) % maxSize == headPointer;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return headPointer == tailPointer;
    }

    //得到队列中有效数据的个数
    public void getValidData() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空");
        }
        validData = (tailPointer - headPointer + maxSize) % maxSize;
        System.out.println("有效数据的个数为:" + validData + "个");
    }

    //往队列中添加数据
    public void addData(int data) throws Exception {
        //判断队列是否已满
        if (isFull()) {
            throw new Exception("都满了还加啥");
        }
        arrForQueue[tailPointer] = data;
        tailPointer = (tailPointer + 1) % maxSize;
        System.out.println(tailPointer);
    }

    //取出队列中的数据
    public int getData() throws Exception {
        if (isEmpty()) {
            throw new Exception("都空了还取啥");
        }
        int data = arrForQueue[headPointer];
        headPointer = (headPointer + 1) % maxSize;
        return data;
    }

    //打印队列中的所有数据
    public void printData() throws Exception {
        if (isEmpty()) {
            throw new Exception("都空了还打印啥");
        }
        for (int i = headPointer; i < headPointer+((tailPointer -headPointer+ maxSize) % maxSize); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arrForQueue[i % maxSize]);
        }
    }

}