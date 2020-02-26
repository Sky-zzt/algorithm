package recuriondivide.Recursiveelimination;

import java.util.Stack;

public class Testallunrecursion {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void preunrecurion(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(head);

            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + "  ");
                if (head.right != null) {
                    stack.add(head.right);

                }
                if (head.left != null) {
                    stack.push(head.left);
                }


            }

        }
        //System.out.println();
    }
    //左侧连的方法
    public static void subpreunrecurion(Node node,Stack<Node> stack){
        //Stack<Node> stack = new Stack<>();
        while (node!=null){

            System.out.println(node.value);
            stack.push(node.right);
            node=node.left;
        }


    }
    public static void newpreunrecurion(Node node){
        Stack<Node> stack = new Stack<>();
        while (true){

            subpreunrecurion(node,stack);
            if (stack.isEmpty())break;
            node=stack.pop();
        }

    }
    //左侧连法
    public static void inorderunrecurion(Node head,Stack<Node> stack ){
        while (head!=null){

            stack.push(head);
            head=head.left;
        }



    }

    public static void newinorderunrecurion(Node node){
        Stack<Node> stack = new Stack<>();
        while (true){
            inorderunrecurion(node,stack);
            if (stack.isEmpty())break;
            node=stack.pop();
            System.out.println(node.value);
            node=node.right;
        }

    }
    //求树高度
    public static int  height(Node head){

        if (head!=null){
            int lheight=height(head.left);
            int rheght=height(head.right);
            int max=lheight>rheght?lheight:rheght;
            return max+1;
        }else {
            return 0;
        }


    }
//主函数
    public static void main(String[] args) {

        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);
    // preunrecurion(head);

      //  int height = height(head);
       // System.out.println(height);
        //newpreunrecurion(head);
        System.out.println("======================");
        newinorderunrecurion(head);
    }
}
