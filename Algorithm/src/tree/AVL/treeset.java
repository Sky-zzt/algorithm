package tree.AVL;

import java.util.Map;
import java.util.TreeMap;

public class treeset {
    public static void main(String[] args) {
//红黑叔的任何操作都是logn  他有适合的场景
        TreeMap<Object, Object> treeMap = new TreeMap<>();
        treeMap.put(1,'z');
        treeMap.put(2,'o');
        treeMap.put(3,'n');
        treeMap.put(5,'g');
        treeMap.put(6,'t');
        treeMap.firstKey();
        Map.Entry<Object, Object> ceilingEntry = treeMap.ceilingEntry(1);
        System.out.println(ceilingEntry);
        System.out.println(treeMap.containsKey(1));
        System.out.println(treeMap.lastKey());//  最大的key 红黑树logn   哈希表 n
        System.out.println(treeMap.ceilingKey(5));//找到刚那比5大的那个数
    }
}
