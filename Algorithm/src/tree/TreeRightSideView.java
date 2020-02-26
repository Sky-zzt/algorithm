package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeRightSideView {
    public static class Node {
        int data;
        Node right;
        Node left;

        public void setRightnode(Node rightnode) {
            this.right = rightnode;
        }

        public void setLeftnode(Node leftnode) {
            this.left = leftnode;
        }

        public Node(int data) {
            this.data = data;
        }
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


    }

    public static void treerightsideview(Node root) {
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        if (root!=null){

            //queue.offer()
        }

    }


}
