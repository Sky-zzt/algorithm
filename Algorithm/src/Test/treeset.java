package Test;

import java.util.Map;
import java.util.TreeMap;

public class treeset {
    public static void main(String[] args) {
//红黑叔的任何操作都是logn  他有适合的场景
        //treemap 底层是红黑树
        /*
        AVL树本质上是一颗二叉查找树，但是它又具有以下特点：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，
        并且左右两个子树都是一棵平衡二叉树。
        在AVL树中任何节点的两个子树的高度最大差别为一：
二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）它或者是一棵空树，
或者是具有下列性质的二叉树： 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。

         */
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
