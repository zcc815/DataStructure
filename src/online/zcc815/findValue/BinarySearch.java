package online.zcc815.findValue;

/**
 * Project  DataStructures
 * Package  online.zcc815.findValue
 *
 * @Description
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/9/12 15:20
 * @Version 1.0.0
 */
public class BinarySearch {
    public static void main(String[] args) throws Exception {
        //定义一个有序的数组
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i+1;
        }
        int index = binarySearchValue(arr,0,arr.length-1,50);
        System.out.println(index);
    }
    public static int binarySearchValue(int [] arr,int left,int right,int value) throws Exception {
        //判断要查找的值是否越界
        if (left > right || arr[left] > value || arr[right] < value ) {
            throw new Exception("要查找的值越界");
        }
        int mid = (right+left)/2;
        int midValue = arr[mid];
        if (value >midValue){
            //向右递归
          return   binarySearchValue(arr,mid+1,right,value);
        }else if (value < midValue){
            //向左递归
           return binarySearchValue(arr,left,mid-1,value);
        }else{
            return mid;
        }
    }
}
