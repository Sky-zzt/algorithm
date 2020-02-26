package tree;

import org.omg.CORBA.PUBLIC_MEMBER;

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
       //head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.left.left = new Node(5);
        head.left.left.left.left = new Node(6);
      // head.right.right = new Node(7);
      //  System.out.println(getMin(head));
        System.out.println(mindepth(head));
    }
    public static int depth(Node root){
        if (root==null){
            return 0;
        }
        int depth = depth(root.left);
        int depth1 = depth(root.right);

        return Math.max(depth+1,depth1+1);
    }
    public static int mindepth(Node root){
        if (root==null){
            return Integer.MAX_VALUE-100;
        }
        int depth = mindepth(root.left);
        int depth1 = mindepth(root.right);
   //     int min = Math.min(depth + 1, depth1 + 1);

        return Math.min(depth,depth1)+1;  //根节点的1   宏观的想
    }
    public static  int getMin(Node root){
        if (root == null) {
            return Integer.MAX_VALUE-1;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }
        int min = getMin(root.left);
        int min1 = getMin(root.right);
        return Math.min(min+1,min1+1) ;
    }


}
