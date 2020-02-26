package tree;

import java.util.ArrayList;

public class DivideTravesalTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }


        public static ArrayList<Integer> preorderTraversal(TreeNode root) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            // null or leaf
            if (root == null) {
                return result;
            }

            // Divide
            ArrayList<Integer> left = preorderTraversal(root.left);
            ArrayList<Integer> right = preorderTraversal(root.right);

            // Conquer
            result.add(root.val);
            result.addAll(left);
            result.addAll(right);
            return result;
        }

        public static void main(String[] args) {
            TreeNode node = new TreeNode(1);
            TreeNode node1 = new TreeNode(-1);
            TreeNode node2 = new TreeNode(10);
            TreeNode node3 = new TreeNode(5);
            TreeNode node4 = new TreeNode(5);
            node.left = node1;
            node.right = node2;
            node2.left = node3;
            node1.left = node4;
            ArrayList<Integer> integers = preorderTraversal(node);
            for (Integer integer : integers) {
                System.out.println(integer);
            }

        }
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(-1);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(5);
        node.left = node1;
        node.right = node2;
        node2.left = node3;


    }
}