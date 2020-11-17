package online.zcc815.kmp;

/**
 * Project  DataStructures
 * Package  online.zcc815.kmp
 *
 * @Description
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/11/16 22:01
 * @Version 1.0.0
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        String str1 = "zcc张晨晨wyp王亚鹏zf张飞";
        String str2 = "c张";
        int result = violenceMatch(str1, str2);
        if (result!=-1){
            System.out.println("匹配成功,从第"+(result+1)+"位匹配成功");
        }else {
            System.out.println("匹配失败!");
        }

    }

    //暴力匹配
    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int l1 = s1.length;
        int l2 = s2.length;
        int i = 0;
        int j = 0;
        while (i < l1 && j < l2) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j==l2){
            return i-j;
        }else{
            return -1;
        }
    }
}
