package online.zcc815.sparsearray;

import java.io.*;

/**
 * Project  DataStructures
 * Package  online.zcc815
 *
 * @Description 稀疏数组
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/5/31 13:06
 * @Version 1.0.0
 */
public class SparseArray {
    public static void main(String[] args) throws IOException {
        //创建一个冤死的二维数组 11*11
        //0:没预期值,1:黑子 2:白子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[5][7] = 8;
        //打印原始的二维数组
        System.out.println("打印原始的二维数组");
        System.out.println("*********************************");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        System.out.println("*********************************");
        //将二维数组转化为对应的稀疏数组
        //找到有效数据
        int sum = 0;
        for (int[] row : chessArr1) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
            }
        }
        //创建对应稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //将头部数据插入
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[0].length;
        sparseArr[0][2] = sum;
        //创建一个文件用来保存稀疏数组
        File file = new File("sparseArr.txt");
        //创建输出流
        FileWriter fileWriter = new FileWriter(file);
        //保存记录到第几个有效数据
        int count = 0;
        fileWriter.write("得到的稀疏数组为"+"\n");
        //将有效数组插入到稀疏数组中

        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                    fileWriter.write(sparseArr[count][0]+"\t");
                    fileWriter.write(sparseArr[count][1]+"\t");
                    fileWriter.write(sparseArr[count][2]+"\t");
                    fileWriter.write("\r\n");

                }
            }
        }
        //关闭输入流
        fileWriter.close();


        //打印稀疏数组
        System.out.println("得到稀疏数组为");
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println("*********************************");
        //将稀疏数组转化为二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[i].length; j++) {
                chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][j];
            }
        }
        //打印有稀疏数组转化后的二维数组
        System.out.println("由稀疏数组转化的二维数组");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println("*********************************");
    }
}
