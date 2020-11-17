package online.zcc815.sort;

/**
 * Project  DataStructures
 * Package  online.zcc815.sort
 *
 * @Description 插入排序
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/7/28 22:58
 * @Version 1.0.0
 */
public class InsertSort {
    public static void main(String[] args) {
        //待排序的数组
        int[] arr = new int[]{23, 232, 21, 43432, 332, 233,-5};
        int[] result = sort(arr);
        for (int i : result) {
            System.out.print(i+"\n");
        }
    }

    public static int[] sort(int[] arr) {
        //定义待插入的数
        int value = 0;
        //定义插入位置的下标
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            value = arr[i];
            //从后往前寻找插入位置(前边为已经排好序的,后面为待插入的数)
            index = i - 1;
            while (index >= 0 && value < arr[index]) {
                //大数后移
                arr[index+1]=arr[index];
                index--;
            }
            arr[index+1]=value;
        }
        return arr;
    }
}
