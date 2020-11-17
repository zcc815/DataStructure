package online.zcc815.sort;


/**
 * Project  DataStructures
 * Package  online.zcc815.sort
 *
 * @Description
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/8/3 20:03
 * @Version 1.0.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 89, 23, 43, 91, 31};
        int[] result = quickSort(arr, 0, arr.length - 1);
        for (int i : result) {
            System.out.print(i + " ");
        }

    }

    public static int[] quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        //得到中间值
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {

            //找到左边大于中间值的下标
            while (arr[l] < pivot) {

                l += 1;
            }
            //找到右边小于中间值的下标
            while (arr[r] > pivot) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }

        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
        return arr;
    }
}
