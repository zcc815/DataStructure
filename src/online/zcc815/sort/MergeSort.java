package online.zcc815.sort;

import java.util.Arrays;

/**
 * Project  DataStructures
 * Package  online.zcc815.sort
 *
 * @Description 归并排序
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/8/10 20:31
 * @Version 1.0.0
 */
public class MergeSort {
    public static void main(String[] args) {
        int [] arr = new int[]{1,23,432,12,32423,54,3};
        int [] temp = new int[arr.length];
        int[] result = mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(result));

    }
    public static int[] mergeSort(int[] arr,int left,int right,int[] temp){
        if (left < right){
            int mid = (left + right)/2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
        return arr;

    }

    public static int[] merge(int[] arr, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        //指向temp的索引位置
        int t = 0;
        //先把左右两边的数据按照规则填充到temp中
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[t] = arr[l];
                t += 1;
                l += 1;
            } else {
                temp[t] = arr[r];
                t += 1;
                r += 1;
            }
        }
        while (l <= mid) {
            temp[t] = arr[l];
            l += 1;
            t += 1;
        }
        while (r <= right) {
            temp[t] = arr[r];
            r += 1;
            t += 1;
        }
        t=0;
        int tempLeft = left;
        while(tempLeft <=right){
            arr[tempLeft] = temp[t];
            t+=1;
            tempLeft +=1;
        }

        return arr;
    }
}
