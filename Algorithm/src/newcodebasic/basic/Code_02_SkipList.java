package newcodebasic.basic;

import java.util.ArrayList;
import java.util.Iterator;

public class Code_02_SkipList {
	/*
    arraylist是竖的
     */
	public static class SkipListNode {
		public Integer value;
		public ArrayList<SkipListNode> nextNodes;  //10 -》10层   nextNode【0】 指第0层上 他的下一个节点是啥  下一个节点是另外一列的节点
//list内部不是链表链接  list之间是对应层的链表链接  0是高层
		public SkipListNode(Integer value) {
			this.value = value;
			nextNodes = new ArrayList<SkipListNode>();
		}
	}

	public static class SkipListIterator implements Iterator<Integer> {
		SkipList list;
		SkipListNode current;

		public SkipListIterator(SkipList list) {
			this.list = list;
			this.current = list.getHead();
		}

		public boolean hasNext() {
			return current.nextNodes.get(0) != null;
		}

		public Integer next() {
			current = current.nextNodes.get(0);
			return current.value;
		}

		@Override
		public void remove() {

		}
	}
//进阶6 2.41
	public static class SkipList {
		private SkipListNode head;//巨小
		private int maxLevel;//最大层
		private int size;//加进来多少个
		private static final double PROBABILITY = 0.5;

		public SkipList() {
			size = 0;
			maxLevel = 0;
			head = new SkipListNode(null);
			head.nextNodes.add(null);
		}

		public SkipListNode getHead() {
			return head;
		}

		public void add(Integer newValue) {
			if (!contains(newValue)) {
				size++;
				int level = 0;
				while (Math.random() < PROBABILITY) {
					level++;
				}
				while (level > maxLevel) {
					head.nextNodes.add(null);
					maxLevel++;
				}
				SkipListNode newNode = new SkipListNode(newValue);
				SkipListNode current = head;//总是从头开始找   haed 在最上面
				do {
					current = findNext(newValue, current, level);
					newNode.nextNodes.add(0, current.nextNodes.get(level));  //加到list  建立newnode与下一个list的关系
					current.nextNodes.set(level, newNode);//建立当前层与newnode的关系
				} while (level-- > 0);
			}
		}

		public void delete(Integer deleteValue) {
			if (contains(deleteValue)) {
				SkipListNode deleteNode = find(deleteValue);
				size--;
				int level = maxLevel;
				SkipListNode current = head;
				do {
					current = findNext(deleteNode.value, current, level);
					if (deleteNode.nextNodes.size() > level) {
						current.nextNodes.set(level, deleteNode.nextNodes.get(level));
					}
				} while (level-- > 0);
			}
		}

		// Returns the skiplist node with greatest value <= e
		private SkipListNode find(Integer e) {
			return find(e, head, maxLevel);
		}

		// Returns the skiplist node with greatest value <= e
		// Starts at node start and level
		private SkipListNode find(Integer e, SkipListNode current, int level) {
			do {
				current = findNext(e, current, level);
			} while (level-- > 0);
			return current;
		}

		// Returns the node at a given level with highest value less than e
		private SkipListNode findNext(Integer e, SkipListNode current, int level) {
			SkipListNode next = current.nextNodes.get(level);//另外一列的node
			while (next != null) {
				Integer value = next.value;
				if (lessThan(e, value)) { // e < value
					break;
				}
				current = next;
				next = current.nextNodes.get(level);
			}
			return current;
		}

		public int size() {
			return size;
		}

		public boolean contains(Integer value) {
			SkipListNode node = find(value);
			return node != null && node.value != null && equalTo(node.value, value);
		}

		public Iterator<Integer> iterator() {
			return new SkipListIterator(this);
		}

		/******************************************************************************
		 * Utility Functions *
		 ******************************************************************************/

		private boolean lessThan(Integer a, Integer b) {
			return a.compareTo(b) < 0;
		}

		private boolean equalTo(Integer a, Integer b) {
			return a.compareTo(b) == 0;
		}

	}

	public static void main(String[] args) {

	}

}
