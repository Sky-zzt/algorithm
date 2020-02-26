package tree;

public class MinimumDepthofBinaryTree {

     public static class Node {
             public int value;
             public Node left;
             public Node right;

             public Node(int data) {
                 this.value = data;
             }
         }

    public static  int minDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }

    public static int getMin(Node root){
        if (root == null) {
            return Integer.MAX_VALUE;
            //例如 一个节点，左子树是null，右子树还有东西，左子树就会return最大整数这样不影响计算最小depth
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }
}
