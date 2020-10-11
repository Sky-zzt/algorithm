package graph;

import java.util.*;

public class Code_01_BFS {

    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {


        int[][] f = {{1, 2, 3}, {4, 3, 6}, {7, 6, 2}, {1, 2, 10}};
        //  GraphGenerator graphGenerator = new GraphGenerator();
        Graph graph = GraphGenerator.createGraph(f);
        HashMap<Integer, Node> nodes = graph.nodes;
        //dfs(nodes.get(3), new HashSet<Node>());
        dfs2(nodes.get(3));
    }

    public static void dfs2(Node node) {
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        set.add(node);
        System.out.println(node.value);
        stack.add(node);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            for (Node next : pop.nexts) {
                if (!set.contains(next)) {
                    System.out.println(next.value
                    );
                    stack.add(pop);
                    stack.add(next);
                    set.add(next);
                    break;
                }
            }
        }

    }

    public static void dfs(Node node, HashSet<Node> set) {
        set.add(node);
        System.out.println(node.value);
        for (Node next : node.nexts) {
            if (!set.contains(next)) {
                dfs(next, set);
            }
        }
    }
}
