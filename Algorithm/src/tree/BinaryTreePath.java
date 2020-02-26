package tree;

import sun.java2d.pipe.ValidatePipe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BinaryTreePath {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    //通常先验证一个节点的情况
//14	给一棵二叉树，找出从根节点到叶子节点的所有路径
    public static ArrayList<String> path(Node root) {
        ArrayList<String> list = new ArrayList<>();
        if (root == null) {
            return new ArrayList();
        }
        return null;


    }

    public static List<String> binaryTreePaths(Node root) { //
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

           //很多时候都要单独拿出来验证一下  即一个节点的时候
        if (root.left==null&&root.right==null) {
            paths.add("" + root.value);
        }


        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String path : leftPaths) {
            paths.add(root.value + "->" + path);
        }
        for (String path : rightPaths) {
            paths.add(root.value + "->" + path);
        }
        // root is a leaf

        return paths;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        head.left.left.right = new Node(7);

        List<String> path = binaryTreePaths(head);
        for (String s : path) {
            System.out.println(s);
        }
    }


    public static List<String> path1(Node root) {
        ArrayList<String> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        List<String> left = path1(root.left);
        List<String> right = path1(root.right);
        for (String s : left) {
            list.add(root.value+"->"+s);
        }
        for (String s : right) {
            list.add(root.value+"->"+s);
        }

        return list;


    }


}
