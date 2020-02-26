package tree;

public class FlattenBinaryTreetoLinkedList {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }


        public static void FBTL(Node root) {
            helper(root);
        }

        //return的是最后一个节点  理解不了 无所谓 反正就是
        /*
        if (left != null) {
                left.right = root.right;
                root.right = root.left;
                root.left = null;
         */
        /*


         */

        //你把他啥 他就是啥 你想他返回 最后  一个节点 那就按照最后一个节点处理  他就返回最后一个节点
        public static Node helper(Node root) {
            if (root == null) {
                return root;
            }
            Node left = helper(root.left);
            Node right = helper(root.right);
            if (left != null) {
                left.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            if (left != null) {
                return left;
            }
            if ((right != null)) {
                return right;
            }
            return root;
        }

        public static void main(String[] args) {
            Node head = new Node(1);
            head.left = new Node(2);
            head.right = new Node(3);
            head.left.left = new Node(4);
            head.left.right = new Node(5);
            head.right.left = new Node(6);
            head.right.right = new Node(7);
      FBTL(head);

        }
    }

}
