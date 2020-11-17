package online.zcc815.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Project  DataStructures
 * Package  online.zcc815.stack
 *
 * @Description 逆波兰表达式之后缀表达式计算
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/6/29 21:57
 * @Version 1.0.0
 */
public class PolandNotation {
    public static void main(String[] args) {
        String expression = "3 4 + 6 * 7 -";
        List<String> split = getStringList(expression);
        //得到结果
        int result = getResult(split);
        System.out.printf("表达式%s = %d ",expression,result);

    }

    //得到结果
    public static int getResult(List<String> split) {
        //存放结果
        int res = 0;
        //创建一个栈用来存放数字
        Stack<String> stack = new Stack<>();
        for (String s : split) {
            if (s.matches("\\d+")){
                stack.push(s);
            }else if (s .equals("+") ){
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                res = num1 + num2;
                stack.push(new Integer(res).toString());
            }else if (s .equals("-") ){
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                res = num2 - num1;
                stack.push(res+"");
            }else if (s.equals("*")){
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                res = num1 * num2;
                stack.push(res+"");
            }else if (s .equals("/")){
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                res = num2 / num1;
                stack.push(res+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    //得到分割后字符串
    public static List<String> getStringList(String expression) {
        //对字符串进行切割
        String[] strings = expression.split(" ");
        ArrayList<String> arrayList = new ArrayList<>();
        //将切割后的字符串放入arrayList中
        for (String string : strings) {
            arrayList.add(string);
        }
        return arrayList;
    }
    //
}
