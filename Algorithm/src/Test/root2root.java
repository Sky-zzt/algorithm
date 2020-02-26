package Test;

public class root2root {
     public static class Node {
             public int value;
             public Node left;
             public Node right;

             public Node(int data) {
                 this.value = data;
             }
         }
         static class ResultType{
         int root2any;
         int any2any;

             public ResultType(int root2any, int any2any) {
                 this.root2any = root2any;
                 this.any2any = any2any;
             }
         }
         public static ResultType anytoany(Node node){
         if (node==null){
             return new ResultType(0,0);
         }
             ResultType left = anytoany(node.left);
             ResultType right = anytoany(node.right);
             int root2any = Math.max(0, Math.max(left.root2any, right.root2any)) + node.value;
             int anytoany = Math.max(left.any2any, right.any2any);

             return new ResultType(root2any,anytoany);
         }

    public static void main(String[] args) {


    }
}
