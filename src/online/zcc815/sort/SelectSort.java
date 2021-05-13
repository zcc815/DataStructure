package online.zcc815.sort;


/**
 * Project  DataStructures
 * Package  online.zcc815.sort
 *
 * @Description
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/7/20 20:55
 * @Version 1.0.0
 */
public class SelectSort {
    public static void main(String[] args) {
        //定义一个待排序的数组
        int[] arr = new int[]{8, 9, 1, 6, 5, 3, 2, 7};
        //定义中间变量
        int tmp = 0;
        //插入排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]>arr[j]){
                    tmp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=tmp;
                }

            }
            System.out.println("第"+i+"次排序后:");
            for (int k : arr) {
                System.out.print(k+"\t");
            }
        }
    }
}
