package online.zcc815.prim;

import java.util.Arrays;

/**
 * Project  DataStructures
 * Package  online.zcc815.prim
 *
 * @Description
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/11/24 17:20
 * @Version 1.0.0
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},
        };

        MGraph graph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, verxs, data, weight);
        minTree.showGraph(graph);
        minTree.prim(graph, 0);
    }
}

//创建最小生成树
class MinTree {
    public void createGraph(MGraph graph, int verxs, char[] data, int[][] weight) {
        int i, j;
        for (i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    public void prim(MGraph graph, int v) {
        //创建数组用来标记该节点是否被访问过
        int[] visited = new int[graph.verxs];
        //表明当前节点已经被访问过
        visited[v] = 1;
        //记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;
        for (int i = 1; i < graph.verxs; i++) { //n个顶点会产生n-1条边
            for (int j = 0; j < graph.verxs; j++) {//j节点访问过的
                for (int k = 0; k < graph.verxs; k++) {//k节点访问过的
                    if (visited[j] == 1 && visited[k] == 0 && graph.weight[j][k] < minWeight) {
                        //寻找已经访问过的节点何为访问过的节点间的权值最小的边
                        minWeight = graph.weight[j][k];
                        h1 = j;
                        h2 = k;
                    }
                }
            }
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + ">权值" + minWeight);
            //将当前节点标记为已经访问过
            visited[h2] = 1;
            minWeight = 10000;
        }


    }
}

class MGraph {
    int verxs; //表示图的节点个数
    char[] data;//存放节点的数据
    int[][] weight;//存放边

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
