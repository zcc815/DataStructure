package online.zcc815.sort;

/**
 * Project  DataStructures
 * Package  online.zcc815.sort
 *
 * @Description 希尔排序
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/7/29 22:16
 * @Version 1.0.0
 */
public class ShellSort {
    public static void main(String[] args) {
        //定义待排序的数组
        int[] arr = new int[]{234, 2343, 32, 2434, 23, 12, 2, 2345, 15, 3};
        int[] result = getShellSortResult(arr);
        System.out.println("排序后的结果为:");
        for (int i : result) {
            System.out.print(i+" ");
        }

    }

    public static int[] getShellSortResult(int[] arr) {
        //定义临时变量用来存放中间结果
        int tmp = 0;
        //控制要进行分组的次数
        for (int i = arr.length / 2; i > 0; i /= 2) {
            //遍历分割后的数组
            for (int j = i; j < arr.length; j++) {
                //对单个数组进行插入排序
                for (int k = j - i; k >= 0; k -= i) {
                       if (arr[k] > arr[k+i]){
                           tmp = arr[k+i];
                           arr[k+i]=arr[k];
                           arr[k]=tmp;
                       }
                }
            }
        }
        return arr;
    }
}
