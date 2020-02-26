package Test;

import java.util.*;

public class compartor {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }

        public Node() {

        }
    }
    public static void main(String[] args) {

        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.value-o1.value;
            }
        };

        Node node1 = new Node(1);
        Node node2 = new Node(-11);
        Node nodd3 = new Node(12);
        Node nodd4 = new Node(4);
        ArrayList<Node> list = new ArrayList<>();
        list.add(node1);
        list.add(node2);
        list.add(nodd3);
        list.add(nodd4);
        Queue<Node> heap = new PriorityQueue<Node>(4,comparator);
       // Stack<Node> nodes = new Stack<Node>(4, comparator);

        heap.add(node1);
        heap.offer(node2);
        heap.offer(nodd3);
        heap.offer(nodd4);
        for (Node node11 : heap) {
            System.out.println( node11.value);
        }


    }
}
