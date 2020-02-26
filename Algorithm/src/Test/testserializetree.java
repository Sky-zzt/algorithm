package Test;

import tree.SerializeAndReconstructTree;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class testserializetree {
    public static void main(String[] args) {
        SerializeAndReconstructTree.Node head=null;
        head = new SerializeAndReconstructTree.Node(1);
        head.left = new SerializeAndReconstructTree.Node(2);
        head.right = new SerializeAndReconstructTree.Node(3);
        head.left.left = new SerializeAndReconstructTree.Node(4);
        head.right.right = new SerializeAndReconstructTree.Node(5);
        String serialize = serialize(head);
        SerializeAndReconstructTree.Node node = reconByPreString(serialize);

    }

    public static String serialize(SerializeAndReconstructTree.Node root) {
        if (root == null) {
            return "#_";
        }
        String res = root.value+"_";
        res = res + serialize(root.left);
        res = res + serialize(root.right);

        return res;
    }

    public static void reconstructTree(String s){
        String[] chars = s.split("_");

        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i < chars.length; i++) {
            queue.offer(chars[i]);
        }


    }
    public static SerializeAndReconstructTree.Node reconByPreString(String preStr) {
        String[] values = preStr.split("_");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i != values.length; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    public static SerializeAndReconstructTree.Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        SerializeAndReconstructTree.Node head = new SerializeAndReconstructTree.Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
}
