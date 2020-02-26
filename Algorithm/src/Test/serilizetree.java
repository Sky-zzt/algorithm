package Test;

public class serilizetree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    public static String serilize(Node root){
        if (root==null){
            return "#";
        }
        String s = new String();
        String serilize = serilize(root.left);
        String serilize1 = serilize(root.right);
        s=serilize+"_"+root.value+"_"+serilize1;
        return s;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
     head.left.left = new Node(4);
        head.left.left.right= new Node(5);
        head.left.left.right.left= new Node(6);
        System.out.println(serilize(head));
    }
}
