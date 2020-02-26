package tree;

public class ReverseTree {
     public static class Node {
             public int value;
             public Node left;
             public Node right;

             public Node(int data) {
                 this.value = data;
             }
         }

    public static void main(String[] args) {

        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.right.left=new Node(1);
        head.right.right =new Node(10);


        preOrderRecur(reverse(head));

    }
    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static Node reverse(Node root){
         if (root==null){
             return root;
         }

        Node left = reverse(root.left);
        Node right = reverse(root.right);
      return   swap(root,left,right);

    }
    public static Node swap(Node root,Node nodeL,Node nodeR){
         root.right=nodeL;
         root.left=nodeR;
         return  root;

    }
}
