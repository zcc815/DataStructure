package online.zcc815.kmp;

import java.util.Arrays;

/**
 * Project  DataStructures
 * Package  online.zcc815.kmp
 *
 * @Description
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/11/16 22:53
 * @Version 1.0.0
 */
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        System.out.println(Arrays.toString(kmpNext("AAAB")));
        System.out.println(kmpSearch(str1,str2,kmpNext(str2)));

    }

    public static int kmpSearch(String str1,String str2,int [] next){
        for (int i =0,j = 0;i <str1.length();i++){
            while(j>0&&str1.charAt(i)!=str2.charAt(j)){
                j=next[j-1];
            }
            if (str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if (j ==str2.length()){
                return i-j+1;
            }
        }
        return -1;
    }
    /**
     * @param str 要搜索的字符串
     * @return 匹配值表
     */
    public static int[] kmpNext(String str){
        //创建数据组保存部分匹配值
        int[] next = new int[str.length()];
        next[0] = 0;//如果待匹配的字符串长度为1,那么部分匹配值就是0
        for (int i = 1,j=0;i<str.length();i++){
            while(j>0&&str.charAt(i)!=str.charAt(j)){
                j = next[j-1];
            }
            //当str.charAt(i) == str.charAt(j)满足时,部分匹配值就是加1
            if (str.charAt(i) == str.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;

    }
}
