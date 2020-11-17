package online.zcc815.findValue;

/**
 * Project  DataStructures
 * Package  online.zcc815.findValue
 *
 * @Description 插值查找(前提是数组必须有序)
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/9/12 14:59
 * @Version 1.0.0
 */
public class InsertValueSearch {
    public static void main(String[] args) throws Exception {
        //定义一个有序的数组
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i+1;
        }
        int index = valueSearch(arr,0,arr.length-1,100);
        System.out.println(index);
    }

    /**
     *
     * @param arr 待查找的数组(有序)
     * @param left 数组的左索引边界值
     * @param right 数组的右索引边界值
     * @param value 待查找的值
     * @return 待查找值的索引
     * @throws Exception 查找的值越界
     */
    public static int valueSearch(int[] arr, int left, int right, int value) throws Exception {
        //判断要查找的值是否越界
        if (left > right || arr[left] > value || arr[right] < value ) {
            throw new Exception("要查找的值越界");
        }
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];
        if (value > midValue) {
            //向右递归
            return valueSearch(arr, mid + 1, right, value);
        } else if (value < midValue) {
            //向左递归
            return valueSearch(arr, left, mid - 1, value);
        } else {
            return mid;
        }
    }
}
