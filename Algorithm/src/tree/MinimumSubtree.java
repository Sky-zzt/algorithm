package tree;

public class MinimumSubtree {
    /*
    给一棵二叉树, 找到和为最小的子树, 返回其根节点。
思路 先求每个子树的和 再找和最小的
     */
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node minimunsubtree(Node root, int sum) {
        if (root == null) {
            return root;
        }

        return null;
    }

    //求每个子树的和的最小值
//记住这个方法 甚好
    private static int subsum = Integer.MAX_VALUE;
    private static Node subTree = null;

    public static Node minsubtreeSum(Node root) {
        helper1(root);
        return subTree;

    }

    public static int helper1(Node root) {
        if (root == null) {
            return 0;
        }
        int sum = helper1(root.left) + helper1(root.right) + root.value;//求以每个点为根的子树的最下和
        if (subsum > sum) {
            subsum = sum;
            subTree = root;
        }
        return sum;  //思考为啥return sum 而不是 subsum；
    }



}



