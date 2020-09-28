package graph;

public class GraphGenerator {

	public static Graph createGraph(int[][] matrix) {
		Graph graph = new Graph();
		for (int[] integers : matrix) {
			Integer weight = integers[0];
			Integer from = integers[1];
			Integer to = integers[2];
			if (!graph.nodes.containsKey(from)) {
				graph.nodes.put(from, new Node(from));
			}
			if (!graph.nodes.containsKey(to)) {
				graph.nodes.put(to, new Node(to));
			}
			Node fromNode = graph.nodes.get(from);
			Node toNode = graph.nodes.get(to);
			Edge newEdge = new Edge(weight, fromNode, toNode);
			fromNode.nexts.add(toNode);
			fromNode.out++;
			toNode.in++;
			fromNode.edges.add(newEdge);
			graph.edges.add(newEdge);
		}
		return graph;
	}

}
