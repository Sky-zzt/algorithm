package Test;

public class treedepth {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
       head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.left.left = new Node(5);
        head.left.left.left.left = new Node(6);
      // head.right.right = new Node(7);
        System.out.println(depth(head));
    }
    public static int depth(Node root){
        if (root==null){
            return 0;
        }
        int depth = depth(root.left);
        int depth1 = depth(root.right);

        return Math.max(depth+1,depth1+1);
    }


}
