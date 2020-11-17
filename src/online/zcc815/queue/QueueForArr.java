package online.zcc815.queue;

/**
 * Project  DataStructures
 * Package  online.zcc815
 *
 * @Description
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/6/1 22:28
 * @Version 1.0.0
 */
public class QueueForArr {
    public static void main(String[] args) throws Exception {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.addQueueData(16);
        arrayQueue.addQueueData(16);
        arrayQueue.addQueueData(16);
        arrayQueue.addQueueData(16);
        System.out.println("为空吗?" + arrayQueue.isEmpty());
        System.out.println("满了吗?" + arrayQueue.isFull());
        arrayQueue.addQueueData(16);
        System.out.println("满了吗?" + arrayQueue.isFull());
        System.out.println("头部数据为" + arrayQueue.getHeadPointerData());
        arrayQueue.printQueue();
    }
}

class ArrayQueue {
    //队列最大的容量
    private int maxSize;
    //队列头指针
    private int headPointer;
    //队列尾指针
    private int tailPointer;
    //创建数组用来保存队列中的数据
    private int[] queueArr;

    //队列构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        //初始状态头指针指向头部位置
        headPointer = -1;
        //初始状态尾指针指向头部位置
        tailPointer = -1;
        queueArr = new int[maxSize];
    }

    //判断队列是否为空
    public boolean isEmpty() {
        //头部数据和尾部数据相同时即为空
        return headPointer == tailPointer;
    }

    //判断队列是否已满
    public boolean isFull() {
        return tailPointer == maxSize - 1;
    }

    //往队列里添加元素
    public void addQueueData(int data) throws Exception {
        if (isFull()) {
            throw new Exception("队列已满,不能添加数据了");
        }
        tailPointer++;
        queueArr[tailPointer] = data;
    }

    //取出队列中的数据
    public void getQueueData() throws Exception {
        //判断队列是否为空
        if (isEmpty()) {
            throw new Exception("队列已经空了,你还能取啥,歇歇吧!!");
        }
        headPointer++;
    }

    //得到队列的头部数据
    public int getHeadPointerData() throws Exception {
        if (isEmpty()) {
            throw new Exception("都空了,头肯定没有了呀");
        }
        return queueArr[headPointer + 1];
    }

    //打印队列的所有元素
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("都空了,还打印啥");
        }
        for (int i = 0; i < queueArr.length; i++) {
            System.out.printf("queueArr[%d]=%d\n", i, queueArr[i]);

        }
    }
}
