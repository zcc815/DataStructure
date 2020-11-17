package online.zcc815.Tree;

import java.util.Arrays;

/**
 * Project  DataStructures
 * Package  online.zcc815.Tree
 *
 * @Description
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/10/20 19:26
 * @Version 1.0.0
 */
public class HeapSort {
    public static void main(String[] args) {
        //要求数据进行升序排列
        int arr[] = {4,6,8,5,9,10};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    //编写一个堆排序的方法
    public static void heapSort(int arr[]){
        System.out.println("堆排序!!");
        for (int i = arr.length/2-1; i >=0; i--) {
            adjustHeap(arr,i,arr.length);
        }
        for (int i = arr.length-1; i >0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,i);
        }
    }

    /**
     * @param arr 待调整的数组
     * @param i   表示叶子节点在数组中的索引
     * @param length 表示对多少个元素进行调整
     */
    public static void adjustHeap(int arr[],int i,int length){
        int temp = arr[i];
        for (int k = i*2+1; k < length; k= k*2+1) {
            if (k+1 < length && arr[k] < arr[k+1]){
                k++;
            }
            if (arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }
}

