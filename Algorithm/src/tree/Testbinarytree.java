package tree;

public class Testbinarytree {
     public static class Node {
             public int value;
             public Node left;
             public Node right;

             public Node(int data) {
                 this.value = data;
             }
         }
static  class  resultType{
         Node maxAvgNode;
         int maxAvg;

    public resultType(Node maxAvgNode, int maxAvg) {
        this.maxAvgNode = maxAvgNode;
        this.maxAvg = maxAvg;
    }
}
public static resultType getMaxAvgSubTree(Node root){
         if (root==null){
             return new resultType(root,0);
         }
         return null;
}


    public static void main(String[] args) {



    }
}
