package tree;

import java.util.ArrayList;
import java.util.Stack;

public class NearestPublicAncestor {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<String> list = new ArrayList<>();
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
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        node4.right=node8;
        //tostack(node1,node7,stack,list);
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                System.out.println(chars[j]);
            }



            System.out.println(list.get(i));
        }
    }
    public static void tostack(Node root, Node node,Stack stack, ArrayList<ArrayList<Stack>> result){
        Stack stack1 = new Stack<>();
        int finish=0;
        if (root==null||finish==1){
            return;
        }
        stack.push(root.value);
        if (root==node){
            result.add(new ArrayList<Stack>(stack));
            result.add(new ArrayList<Stack>(stack1));
            finish=1;
        }
        tostack(root.left,node,stack,result);
        tostack(root.right,node,stack,result);
        stack.pop();

    }
    public static Node nearestpublicancester(Node root,Node node1,Node node2){
        ArrayList<String> result1 = new ArrayList<>();
        ArrayList<String> result2 = new ArrayList<>();
       // tostack(root,node1,result1);
     //   tostack(root,node2,result2);
        int i=0;
        int j=0;
        for (int k = 0; k <result1.size() ; k++) {
            System.out.println(result1.get(i));

        }
       // while (result1[i]==result2[j]){


      //  }


        return null;
    }


}
