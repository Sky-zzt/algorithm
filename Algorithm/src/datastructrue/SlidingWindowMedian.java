package datastructrue;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 使用九章算法强化班中讲到的 HashHeap。即一个 Hash + Heap。 Hash 的 key 是 Heap 里的每个元素，值是这个元素在 Heap 中的下标。
 *
 * 要做这个题首先需要先做一下 Data Stream Median。这个题是只在一个集合中增加数，不删除数，然后不断的求中点。 Sliding Window Median，就是不断的增加数，删除数，然后求中点。比 Data Stream Median 难的地方就在于如何支持删除数。
 *
 * 因为 Data Stream Median 的方法是用 两个 Heap，一个 max heap，一个min heap。所以删除的话，就需要让 heap 也支持删除操作。 由于 Python 的 heapq 并不支持 logn 时间内的删除操作，因此只能自己实现一个 hash + heap 的方法。
 *
 * 总体时间复杂度 O(nlogk)O(nlogk)，n是元素个数，k 是 window 的大小。
 */
public class SlidingWindowMedian {
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        TreeSet<Node> minheap = new TreeSet<Node>();
        TreeSet<Node> maxheap = new TreeSet<Node>();
        ArrayList<Integer> result = new ArrayList<Integer> ();

        if (k == 0)
            return result;

        int half = (k+1)/2;
        for(int i=0; i<k-1; i++) {
            add(minheap, maxheap, half, new Node(i, nums[i]));
        }
        for(int i=k-1; i<n; i++) {
            add(minheap, maxheap, half, new Node(i, nums[i]));
            result.add(minheap.last().val);
            remove(minheap,maxheap, new Node(i-k+1, nums[i-k+1]));
        }
        return result;
    }

    void add(TreeSet<Node>minheap, TreeSet<Node> maxheap, int size, Node node) {
        if (minheap.size()<size) {
            minheap.add(node);
        }
        else {
            maxheap.add(node);
        }
        if (minheap.size()==size) {
            if (maxheap.size()>0 && minheap.last().val>maxheap.first().val) {
                Node s = minheap.last();
                Node b = maxheap.first();
                minheap.remove(s);
                maxheap.remove(b);
                minheap.add(b);
                maxheap.add(s);
            }
        }
    }

    void remove(TreeSet<Node> minheap, TreeSet<Node> maxheap, Node node) {
        if (minheap.contains(node)) {
            minheap.remove(node);
        }
        else {
            maxheap.remove(node);
        }
    }
}

class Node implements Comparable<Node>{
    int id;
    int val;
    Node(int id, int val) {
        this.id = id;
        this.val = val;
    }
    public int compareTo(Node other) {
        Node a =(Node)other;
        if (this.val == a.val) {
            return this.id - a.id;
        }
        return this.val - a.val;
    }
}
