package online.zcc815.findValue;

import java.util.Arrays;

/**
 * Project  DataStructures
 * Package  online.zcc815.findValue
 *
 * @Description 斐波那契数列查找固定值
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/9/21 21:44
 * @Version 1.0.0
 */
public class FibonacciValue {
    //定义斐波那契数组的最大长度
    static int  maxSize = 90;

    public static void main(String[] args) throws Exception {
        //定义待查找的数组
        int[] arr = {1, 23, 45, 47, 68, 80};
        System.out.println("index="+ findValue(arr,90));

    }

    //创建斐波那契数组
    public static int[] createFb(int size) throws Exception {
        if (size < 2) {
            throw new Exception("定义的斐波那契数组长度过小");
        }
        //斐波那契数组的前两位固定为1,1
        int s1 = 1;
        int s2 = 1;
        int[] arr = new int[size];
        arr[0] = s1;
        arr[1] = s2;
        for (int i = 2; i < size - 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    /**
     * 查找目标值
     *
     * @param arr 目标数组
     * @param key 目标值
     * @return 目标值在数组中的下标
     */
    public static int findValue(int[] arr, int key) throws Exception {
        //定义高位低位
        int high = arr.length - 1;
        int low = 0;
        //定义mid位
        int mid = 0;
        int k = 0;
        int f[] = createFb(maxSize);
        //获取斐波那契数组值的下标
        while (high > f[k] - 1) {
            k++;
            System.out.println(k+" "+f[k]);
        }
        //实际情况中f[k]存在比arr数组的长度大的情况,故做以下处理,用原数组最后一位的值填充上去
        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        //f[k] = f[k-1]+f[k-2]
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {//说明在前面
                high = mid - 1;
                k--;
            } else if (key > temp[mid]) { //说明在后面
                low = mid + 1;
                k -= 2;
            }else {
                if(mid <=high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}
