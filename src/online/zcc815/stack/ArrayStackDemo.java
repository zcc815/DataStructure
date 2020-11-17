package online.zcc815.stack;

/**
 * Project  DataStructures
 * Package  online.zcc815.stack
 *
 * @Description
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/6/22 22:25
 * @Version 1.0.0
 */
public class ArrayStackDemo {
    public static void main(String[] args) throws Exception {
        //创建栈
        StackDemoTest stack = new StackDemoTest(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.printStack();
        System.out.println("-------------");
        //测试栈是否已经满了
        //stack.pop(6);
        //出栈
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.printStack();
        System.out.println("-------------");

    }
}
class StackDemo{
    private int maxSize; //栈的大小
    private int[] stack  ; //存储数据
    private int top = -1 ; //栈顶

    public StackDemo() {
    }

    public StackDemo(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int[] getStack() {
        return stack;
    }

    public void setStack(int[] stack) {
        this.stack = stack;
    }

    //判断栈是否为null
    public boolean isNull(){
        return top == -1;
    }
    //判断栈是否满了
    public boolean isFull(){
        return maxSize==top+1;
    }
    //入栈操作
    public void pop(int value){
        //判断栈是否已经满了
        if (isFull()){
            System.out.println("栈已经满了");
            return;
        }
        stack[top+1]=value;
        top++;
    }
    //出栈操作
    public int push() throws Exception {
        //判断栈是否为null
        if (isNull()){
            throw new Exception("栈已经空");
        }
        top--;
        return stack[top+1];
    }
    //打印栈中的数据
    public void printStack() throws Exception {
        //判断栈是否为null
        if (isNull()){
            throw new Exception("栈已经空");
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
