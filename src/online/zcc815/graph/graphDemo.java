package online.zcc815.graph;

import jdk.nashorn.internal.ir.CallNode;

import javax.swing.text.html.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Project  DataStructures
 * Package  online.zcc815.graph
 *
 * @Description
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/11/3 20:39
 * @Version 1.0.0
 */
public class graphDemo {
    public static void main(String[] args) {
        int n = 5;
        String vertex[] = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);
        for (String s : vertex) {
            graph.addVertexList(s);
        }
        //添加边 A-B A-C B-C B-D B-E
        graph.addNumEdges(0, 1, 1);
        graph.addNumEdges(0, 2, 1);
        graph.addNumEdges(1, 2, 1);
        graph.addNumEdges(1, 3, 1);
        graph.addNumEdges(1, 4, 1);
        graph.showGraph();
        //测试深度遍历算法
//        System.out.println("深度遍历");
//        graph.dfs();
        System.out.println("广度优先遍历");
        graph.bfs();
    }
}

class Graph {
    //顶点的值
    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;
    private boolean[] istVisited;

    public Graph(int n) {
        edges = new int[n][n];
        numOfEdges = 0;
        vertexList = new ArrayList<String>(n);
        istVisited = new boolean[5];
    }

    //添加边
    public void addNumEdges(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    //添加节点
    public void addVertexList(String vertex) {
        vertexList.add(vertex);
    }

    //得到节点的数
    public int getVertexListNum() {
        return vertexList.size();
    }

    //返回下标的值
    public String getValueIndex(int i) {
        return vertexList.get(i);
    }

    //得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //得到权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    //得到第一个邻接点的下标w
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //得到相邻节点的下一节点
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //深度优先遍历算法
    public void dfs(boolean[] isVisited, int i) {
        System.out.print(getValueIndex(i) + "=>");
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            w = getNextNeighbor(i, w);
        }
    }

    public void dfs() {
        //遍历所有的节点,进行dfs
        for (int i = 0; i < getNumOfEdges(); i++) {
            if (!istVisited[i]) {
                dfs(istVisited, i);
            }
        }
    }

    //广度优先遍历算法
    public void bfs(boolean[] istVisited, int i) {
        //表示队列头结点对应的下标
        int u;
        //表示邻接点
        int w;
        //记录访问顺序
        LinkedList queue = new LinkedList();
        System.out.print(getValueIndex(i) + "==>");
        istVisited[i] = true;
        queue.addLast(i);
        while (!queue.isEmpty()) {
            u = (Integer) queue.removeFirst();
            //得到第一个邻接点的下标
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!istVisited[w]) {
                    System.out.print(getValueIndex(w) + "==>");
                    istVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u, w);
            }
        }
    }

    public void bfs() {
        for (int i = 0; i < getVertexListNum(); i++) {
            if (!istVisited[i]) {
                bfs(istVisited, i);
            }
        }
    }
}
