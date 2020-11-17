package online.zcc815.dynamic;

/**
 * Project  DataStructures
 * Package  online.zcc815.dynamic
 *
 * @Description
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/11/9 21:42
 * @Version 1.0.0
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        //背包的重量
        int[] w = {1, 4, 3};
        //物品的价值
        int[] val = {1500, 3000, 2000};
        //定义背包的容量
        int m = 4;
        //物品的个数
        int n = val.length;
        //创建二维数组,表示前i个物品中装入背包的最大价值
        int[][] v = new int[n + 1][m + 1];
        //记录商品的存放情况
        int[][] path = new int[n + 1][m + 1];
        //初始化第一行和第一列
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }

        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }

        //动态规划
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
//                    System.out.println(i+" "+j);
//                    v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
        int j = path[0].length - 1;
        int i = path.length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包\n", i);
                j -= w[i - 1];
            }
            i--;
        }

    }
}
