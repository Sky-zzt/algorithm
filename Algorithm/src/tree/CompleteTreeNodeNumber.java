package tree;

public class CompleteTreeNodeNumber {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
/*
拿到一个节点  就看右子树的左边界到没到你最后一层
到了左子树满的
没到右子就是满的
只不过右子树满和左子树满的高度不一样而已l
剩下的节点递归的去求这个节点

 */
//O（logN）^2
	public static int nodeNum(Node head) {
		if (head == null) {
			return 0;
		}
		return bs(head, 1, mostLeftLevel(head, 1));
	}
//以node为头的节点个数
	public static int bs(Node node, int level, int h) {  //l时node在当前第几层   h时树的深度
		if (level == h) {
			return 1;
		}
		if (mostLeftLevel(node.right, level + 1) == h) {
			return (1 << (h - level)) + bs(node.right, level + 1, h);
		} else {
			return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
		}
	}


	public static int mostLeftLevel(Node node, int level) {
		while (node != null) {
			level++;
			node = node.left;
		}
		return level - 1;
	}
	static  class ResultType{
		int level=1;
		int NodeAmt=0;
		public ResultType() {
		}
		public ResultType(int level, int nodeAmt) {
			this.level = level;
			NodeAmt = nodeAmt;
		}
	}
	public static ResultType process(Node root){
		if (root==null){
			return new ResultType(0,0);
		}
		int h = mostLeftLevel(root, 1);
		int level = mostLeftLevel(root, new ResultType().level);
		ResultType left = process(root.left);
		ResultType right = process(root.right);
		//if (mostLeftLevel(left.))


return new ResultType(level,left.NodeAmt+right.NodeAmt+1);

	}


	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		System.out.println(nodeNum(head));

	}

}
