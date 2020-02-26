package newcodebasic.basic;

public class Code_01_MorrisTraversal {

	
	
	public static void process(Node head) {
		if(head == null) {
			return;
		}
		
		// 1
		//System.out.println(head.value);
		
		
		process(head.left);
		
		// 2
		//System.out.println(head.value);
		
		
		process(head.right);
		
		// 3
		//System.out.println(head.value);
	}
	
	/*
	如果你用递归实现树的遍历，那么他的空间复杂度一定是O(logN)的【树高】。

但是的的确确存在着神奇的O(1)空间复杂度的遍历方法-Morris遍历。

Morris的时间复杂度O(n)，简略证明：对于一个节点x，我们需要去访问它左子树的右边界两次，而所有节点的右边界长度累加就是N，所以访问2*N次，复杂度为O(N)。

我们之所以要用递归的方式遍历，原因仅仅是我们没办法直接回到上一个节点，而递归所压的栈，可以帮助我们回退。但是，递归的代价往往是昂贵的，系统帮我们压的栈不仅仅是参数，还有当前句柄等等一堆信息，浪费的空间是很可观的，就算是手写的栈，依旧摆脱不了O(logN)的空间代价。如果有一条指向上面节点的指针就好了。。。。。。嗯，我们可以察觉，叶子节点的左孩子和有孩子都是指向null的，能不能利用起来呢。。。。。。这个很像一种数据结构-线索树。

Morris和线索树的思想很像，但是并没有线索化那么繁琐的代价。Morris的基本过程：

我们把当前正在访问的节点记为cur。

1）如果cur没有左孩子，那么cur到右孩子节点去cur=cur.right。

2）如果cur有左孩子，找到cur的左子树上的最右节点，记为mostright:

    A.如果mostright.right==null  让mostright.right=cur,cur向其左孩子移动

    B.如果mostright.right==cur   让mostright.right=null,cur向右移动

	 */
	public static class Node {
		public int value;
		Node left;
		Node right;

		public Node(int data) {
			this.value = data;
		}
	}
/*
Morris的实质：如果一个节点有左子树，会来到该节点两次，否则只来到一次。
而递归的实质是，不管如何都访问一个节点三次。先序中序和后序也只是在哪一次访问时打印而已。
 */
	public static void morrisIn(Node head) {
		if (head == null) {
			return;
		}
		Node cur = head;
		Node mostright = null;
		while (cur != null) {
			mostright = cur.left;
			if (mostright != null) {
				while (mostright.right != null && mostright.right != cur) {
					mostright = mostright.right;
				}
				if (mostright.right == null) {
					mostright.right = cur;
					cur = cur.left;
					continue;
				} else {
					mostright.right = null;
				}
			}
			System.out.print(cur.value + " ");
			cur = cur.right;
		}
		System.out.println();
	}

	public static void morrisPre(Node head) {
		if (head == null) {
			return;
		}
		Node cur = head;
		Node mostright = null;
		while (cur != null) {
			mostright = cur.left;
			if (mostright != null) {
				while (mostright.right != null && mostright.right != cur) {
					mostright = mostright.right;
				}
				if (mostright.right == null) {
					mostright.right = cur;
					System.out.print(cur.value + " ");
					cur = cur.left;
					continue;
				} else {
					mostright.right = null;
				}
			} else {
				System.out.print(cur.value + " ");
			}
			cur = cur.right;
		}
		System.out.println();
	}

	public static void morrisPos(Node head) {
		if (head == null) {
			return;
		}
		Node cur = head;
		Node mostright = null;
		while (cur != null) {
			mostright = cur.left;
			if (mostright != null) {
				while (mostright.right != null && mostright.right != cur) {
					mostright = mostright.right;
				}
				if (mostright.right == null) {
					mostright.right = cur;
					cur = cur.left;
					continue;
				} else {
					mostright.right = null;
					printEdge(cur.left);
				}
			}
			cur = cur.right;
		}
		printEdge(head);
		System.out.println();
	}

	public static void printEdge(Node head) {
		Node tail = reverseEdge(head);
		Node cur = tail;
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.right;
		}
		reverseEdge(tail);
	}

	public static Node reverseEdge(Node from) {
		Node pre = null;
		Node next = null;
		while (from != null) {
			next = from.right;
			from.right = pre;
			pre = from;
			from = next;
		}
		return pre;
	}

	// for test -- print tree
	public static void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public static void printInOrder(Node head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.value + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		Node head = new Node(4);
		head.left = new Node(2);
		head.right = new Node(6);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.right.left = new Node(5);
		head.right.right = new Node(7);
		printTree(head);
		morrisIn(head);
		morrisPre(head);
		morrisPos(head);
		printTree(head);

	}

}
