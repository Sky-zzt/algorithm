package tree;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSumToTarget {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    public static List psmain(int sum, Node root) {
        int pathsum = 0;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Stack> result = new ArrayList<>();

        ps(root, stack, pathsum, sum, result);
        return result;
    }

    public static void ps(Node root, Stack stack, int pathsum, int sum, ArrayList result) {

        if (root == null) {
            return;
        }
        pathsum += root.value;
        stack.push(root.value);
        //叶节点
        if (root.left == null && root.right == null && pathsum == sum) {
            result.add(stack.toString());

        }

        ps(root.right, stack, pathsum, sum, result);
        ps(root.left, stack, pathsum, sum, result);
        pathsum -= root.value;
        stack.pop();

    }

    static class ResultType {
        int sum;
        ArrayList<Node> list= new ArrayList<Node>();
     //   int targrt;


        public ResultType(int sum, Node node) {
            this.sum = sum;
            list.add(node);
         //   this.targrt=targrt;
        }
    }

    public static ResultType pathsum(Node root,int target) {
        if (root == null) {
            return new ResultType(0,root);
        }
        ResultType left = pathsum(root.left,target);
        ResultType right = pathsum(root.right,target);
        if (left.sum==target){
            return new ResultType(target,root);
        }
        if (right.sum==target){
            return new ResultType(target,root);
        }
     //   return new ResultType(left.sum+1+right.sum+1,)



return null;

    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(16);
        Node node4 = new Node(15);
        Node node5 = new Node(3);
        Node node6 = new Node(5);
        Node node7 = new Node(6);
        Node node8 = new Node(6);
        node1.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.right = node8;
        ArrayList<Stack> pathsum = (ArrayList<Stack>) psmain(6, node1);
        for (int i = 0; i < pathsum.size(); i++) {
            System.out.println(pathsum.get(i));
        }


    }
    static  class ret{

    }
}
