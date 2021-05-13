package online.zcc815.sort;

/**
 * Project  DataStructures
 * Package  online.zcc815.sort
 *
 * @Description 冒泡排序
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/7/27 22:23
 * @Version 1.0.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 6, 4, 23, 2334, 3432, 32, 34};
        //保存中间结果
        int tmp = 0;
        //判断是否发生交换
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                    flag = true;
                }
            }
            //判断是否发生变化
            if (flag) {
                flag = false;
            } else {
                break;
            }
        }
        //打印冒泡排序后的结果
        System.out.println("排序后的结果为:");
        for (int i : arr) {
            System.out.print(i + "\n");
        }
    }
}
