package online.zcc815.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Project  DataStructures
 * Package  online.zcc815.stack
 *
 * @Description
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/6/28 21:22
 * @Version 1.0.0
 */
public class Calculator {
    public static void main(String[] args) throws Exception {
        String express = "3+2*6-2";
        //创建两个栈用于存放运算符和数
        StackDemoTest numStack = new StackDemoTest(10);
        StackDemoTest operator = new StackDemoTest(10);
        //定义相关的变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int result = 0;
        char val = ' ';
        //开始循环扫描字符串所包含的字符
        while (index < express.length()) {
            //依次得到字符串中的每一个字符
            val = express.substring(index, index + 1).charAt(0);
            //判断是字符还是数字
            if (operator.isOperator(val)) {
                //判断当前符号栈是否为空
                if (!operator.isNull()) {
                    int peek = operator.getPeek();
                    //判断运算符的优先等级
                    //同级
                    if (operator.getPriority(val) <= operator.getPriority(operator.getPeek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operator.pop();
                        result = numStack.getResult(num1, num2, oper);
                        numStack.push(result);
                        operator.push(val);
                    }else { //同级可入
                        operator.push(val);
                    }
                } else {                    //为空直接入符号栈
                    operator.push(val);
                }
            } else {
                //val为ascii码需转换为对应的
                numStack.push(val - 48);
            }
            index++;
        }
        while (true) {
            if (operator.isNull()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operator.pop();
            result = numStack.getResult(num1, num2, oper);
            numStack.push(result);
        }
        System.out.printf("表达式%s = %d", express, result);
    }
}

class StackDemoTest {
    private int maxSize; //栈的大小
    private int[] stack; //存储数据
    private int top = -1; //栈顶

    public StackDemoTest() {
    }

    public StackDemoTest(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //返回栈顶的值
    public int getPeek() {
        return stack[top];
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
    public boolean isNull() {
        return top == -1;
    }

    //判断栈是否满了
    public boolean isFull() {
        return maxSize == top + 1;
    }

    //入栈操作
    public void push(int value) {
        //判断栈是否已经满了
        if (isFull()) {
            System.out.println("栈已经满了");
            return;
        }
        stack[top + 1] = value;
        top++;
    }

    //出栈操作
    public int pop() throws Exception {
        //判断栈是否为null
        if (isNull()) {
            throw new Exception("栈已经空");
        }
        top--;
        return stack[top + 1];
    }

    //打印栈中的数据
    public void printStack() throws Exception {
        //判断栈是否为null
        if (isNull()) {
            throw new Exception("栈已经空");
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    //返回运算符的优先级,优先级是程序员来确定,优先级使用数字表示
    //数字越大,优先级越高
    public int getPriority(int operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是否为运算符
    public boolean isOperator(char val) {
        return val == '*' || val == '/' || val == '+' || val == '-';
    }

    //实现计算
    public int getResult(int num1, int num2, int operator) {
        //用于存放结果
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            //减法有减数和被减数的区别
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            //除法有除数和被除数的区别
            case '/':
                result = num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }
}