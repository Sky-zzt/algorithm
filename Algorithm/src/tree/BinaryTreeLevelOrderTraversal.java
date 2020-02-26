package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void bfs(Node root) {
        if (root == null) {
            return;
        }
        //模板样例
        //若不需要分层 去掉for循环
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue != null) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                System.out.println(queue.poll().value);
                if (root.left!=null){
                    queue.add(root.left);
                }
                if (root.right!=null){
                    queue.add(root.right);
                }
            }

        }

    }
////模板样例
//        //若不需要分层输出  去掉for循环   加for只是为了输出的时候分层  正常的进队出队 加不加for没有区别
    public static List<List<Integer>> levelOrder(Node root) {
        List result = new ArrayList();

        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node head = queue.poll();
                level.add(head.value);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        head.left.left.right = new Node(7);
        List<Integer> lists1 = levelOrder1(head);
        List<List<Integer>> lists = levelOrder(head);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }


    }
    public static List<Integer> levelOrder1(Node root) {
        List result = new ArrayList();

        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        ArrayList<Integer> level = new ArrayList<Integer>();

        while (!queue.isEmpty()) {
        //   ArrayList<Integer> level = new ArrayList<Integer>();
            //int size = queue.size();
           // for (int i = 0; i < size; i++) {
                Node head = queue.poll();
                level.add(head.value);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
        //    }
        //    result.add(level);
        }

        return level;
    }


}
