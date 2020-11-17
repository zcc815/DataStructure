package online.zcc815.dac;

/**
 * Project  DataStructures
 * Package  online.zcc815.dac
 *
 * @Description
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/11/8 22:45
 * @Version 1.0.0
 */
public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(5,'A','B','C');

    }
    public static void hanoiTower(int num,char a,char b,char c){
        if(num == 1){
            System.out.println("第1个盘子从"+a+"->"+c);
        }else{
            //除了最底层的其余均看作一个盘
            hanoiTower(num -1,a,c,b);
            //把最下边的盘从A到C
            System.out.println("第"+num+"个盘子从"+a+"->"+c);
            //把B塔所有盘移动到C塔
            hanoiTower(num-1,b,a,c);
        }
    }
}

