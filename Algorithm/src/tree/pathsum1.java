package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pathsum1 {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
     /*
     给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。
      */

    public static List<List<Integer>> path(Node root, int target) {
        if (root == null) {
            return null;
        }
        //需要考虑只有一个节点 且不等于traget的情况
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        helper(root, target, arrayList, list);
        return list;

    }

    //先思考递归的定义 以及按这个题来说 他该怎们样的结束
    private static void helper(Node root, int target, ArrayList<Integer> arrayList, List<List<Integer>> list) {

        arrayList.add(root.value);
        //递归结束条件
        if (target == 0 && root.left == null && root.right == null) {  //如果不限制以叶子节点作为结束  可以 去掉 后面两个root.left==null&&root.right==null
            list.add(new ArrayList<>(arrayList));
        }

        helper(root.left, target - root.value, arrayList, list);
        helper(root.right, target - root.value, arrayList, list);
        arrayList.remove(arrayList.size() - 1);


    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(4);
        System.out.println(allpath(head,7));
       // ArrayList<Integer> integers = new ArrayList<>(2);

    }

    public static List<String> allpath(Node root, int target) {

        List<String> lists = new ArrayList<>();
        if (root == null) {
          //  lists.add(new ArrayList<>(-100));
            return  lists;

        }

        if (root.left==null&&root.right==null&&target==0) {
            lists.add("" + root.value);
        }

      //  List<Integer> integers =;
        List<String> left = allpath(root.left, target - root.value);
        List<String> right = allpath(root.left, target - root.value);
        for (String s : left) {
            lists.add(root.value+" "+s);
        }
        for (String s1 : right) {
            lists.add(root.value+" "+s1);
        }

        return lists;
    }
}
