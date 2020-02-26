package Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TestSerialize {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {


    }

    public static String serialize(Node root) {
        if (root == null) {
            return "{}";
        }

        ArrayList<Node> queue = new ArrayList<Node>();
        queue.add(root);
        for (int i = 0; i < queue.size(); i++) {
            Node node = queue.get(i);
            if (node == null) {
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }

        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append("{");
        buffer.append(queue.get(0).value);
        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i) == null) {
                buffer.append(",#");
            } else {
                buffer.append(",");
                buffer.append(queue.get(i).value);
            }
        }
        buffer.append("}");
        return buffer.toString();
    }

    public static Node deserialze(String data) {
        if (data.equals("{}")) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<Node> queue = new ArrayList<Node>();
        Node root = new Node(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                Node node = new Node(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            if (!isLeftChild) {
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }

}
