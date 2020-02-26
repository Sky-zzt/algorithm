package tree;

import Sort.BucketSort;
import linklist.Rotate;

public class Substructureofthetree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
/*

此题甚好 建议多做几遍
此题甚好 建议多做几遍
此题甚好 建议多做几遍
此题甚好 建议多做几遍
此题甚好 建议多做几遍此题甚好 建议多做几遍此题甚好 建议多做几遍
此题甚好 建议多做几遍此题甚好 建议多做几遍此题甚好 建议多做几遍此题甚好 建议多做几遍此题甚好 建议多做几遍此题甚好 建议多做几遍


输入两棵二叉树A，B，判断B是不是A的子结构。
 */
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        head.left.left.right = new Node(7);
        Node node = new Node(2);
        System.out.println(HasSubtree(head,node));
    }

    public static boolean isSame(Node root1, Node root2) {
        boolean result = false;
        /*
          if(tree1==null){
             return false;
         }
         if(tree2==null){
             return true;
        }
 想想自己为啥这么写  这么写为啥错了         */
        if (root1 != null && root2 != null) {              //


            if (root1.value == root2.value) {
                result = does1treeHaveTree2(root1, root2);
            }
            if (!result) {
                result = isSame(root1.left, root2);
            }
            if (!result) {
                result = isSame(root1.right, root2);
            }
        }

        return result;
    }

    public static boolean does1treeHaveTree2(Node tree1, Node tree2) {
        if (tree1 == null) {
            return false;
        }
        if (tree2 == null) {
            return true;
        }

        if (tree1.value != tree2.value) {
            return false;
        }
        boolean b = does1treeHaveTree2(tree1.left, tree2.left);
        boolean b1 = does1treeHaveTree2(tree1.right, tree2.right);
        return b && b1;
    }

    public static boolean HasSubtree(Node root1, Node root2) {
        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            //如果找到了对应Tree2的根节点的点
            if(root1.value == root2.value){
                //以这个根节点为为起点判断是否包含Tree2
                result = doesTree1HaveTree2(root1,root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.left,root2);
            }

            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.right,root2);
            }
        }
        //返回结果
        return result;
    }

    public static boolean doesTree1HaveTree2(Node node1, Node node2) {
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (node2 == null) {
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (node1 == null) {
            return false;
        }
        //如果其中有一个点没有对应上，返回false
        if (node1.value != node2.value) {
            return false;
        }

        //如果根节点对应的上，那么就分别去子节点里面匹配
        return doesTree1HaveTree2(node1.left,node2.left) && doesTree1HaveTree2(node1.right,node2.right);
    }
}
