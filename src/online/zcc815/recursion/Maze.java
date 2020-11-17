package online.zcc815.recursion;

/**
 * Project  DataStructures
 * Package  online.zcc815.recursion
 *
 * @Description
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/7/2 21:07
 * @Version 1.0.0
 */
public class Maze {
    public static void main(String[] args) {
        //先创建一个迷宫
        int[][] map = new int[8][7];
        //上下全部置1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部置1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        //找路
        setWay(map,1,1);
        //打印小球走过的地图
        System.out.println("小球走过的地图");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 1:表示墙 2:表示可以通行 3:该点已经走过
     * 策略:下右上左
     * @param map 地图
     * @param i 小球的纵坐标
     * @param j 小球的横坐标
     * @return
     */
    public static boolean setWay(int[][] map,int i, int j){
         if (map[6][5] == 2){//通路已经找到
             return true;
         }else{
             if (map[i][j] == 0){
                 map[i][j] = 2;//假定该点可以走通
                 if (setWay(map,i+1,j)){//向下走
                     return true;
                 }else if (setWay(map,i,j+1)){//向右走
                     return true;
                 }else if (setWay(map,i-1,j)){//向上走
                     return true;
                 }else if (setWay(map,i,j-1)){//向左走
                     return true;
                 }else {//说明该点不通
                     map[i][j] = 3;
                     return false;
                 }
             }else {
                 return false;
             }
         }
    }
}
