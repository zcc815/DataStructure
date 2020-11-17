package online.zcc815.greed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Project  DataStructures
 * Package  online.zcc815.greed
 *
 * @Description 贪心算法小Demo 贪心算法就是让我们的程序每一步都作出做好的选择
 * @Author ZCC
 * @Email zcc815@126.com
 * @Date 2020/11/17 19:56
 * @Version 1.0.0
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        HashMap<String, HashSet> broadcasts = new HashMap<>(5);
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");
        //将所有的数据加入到map中
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);
        HashSet<String> allAreas = new HashSet<>();
        //将需要广播的地区存储起来
        for (HashSet hashSet : broadcasts.values()) {
            for (Object o : hashSet) {
                allAreas.add((String) o);
            }
        }
        //存放选择电台的集合
        ArrayList<String> selects = new ArrayList<String>();
        //存放在选择过程中电台覆盖的地区和还没有覆盖的地区
        HashSet<String> tmpSet = new HashSet<>();
        //保存再一次遍历中能够覆盖最大覆盖地区的电台
        String maxKey = null;
        while (allAreas.size() != 0) {
            maxKey = null;
            //遍历broadcast取出对应的key
            for (String key : broadcasts.keySet()) {
                //每进行一次for把tmpSet清空
                tmpSet.clear();
                //当前key所能覆盖的地区
                HashSet areas = broadcasts.get(key);
                tmpSet.addAll(areas);
                //求出temSet与allAreas的交集
                tmpSet.retainAll(allAreas);
                boolean flag = tmpSet.size() > 0 && (maxKey == null || tmpSet.size() > broadcasts.get(maxKey).size());
                if (flag) {
                    maxKey = key;
                }
            }
            //maxKey != null ,将maxKey加入selects
            if (maxKey != null) {
                selects.add(maxKey);
                //将maxKey指向的广播电台覆盖的地区从allAreas去掉
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        System.out.println("得到的选择结果: " + selects);
    }
}
