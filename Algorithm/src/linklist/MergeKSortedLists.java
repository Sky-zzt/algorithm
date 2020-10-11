package linklist;

import java.util.*;

public class MergeKSortedLists {

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

        Node head1 = new Node(1);
        head1.next = new Node(6);
        head1.next.next = new Node(6);
        head1.next.next.next = new Node(9);
        head1.next.next.next.next = new Node(12);
        head1.next.next.next.next.next = new Node(16);
        Node head2 = new Node(-10);
        head2.next = new Node(60);
        head2.next.next = new Node(600);
        Node head3 = new Node(0);
        head3.next = new Node(2);
        head3.next.next = new Node(10);

        head2.next.next.next = new Node(2400);
        head2.next.next.next.next = new Node(20000);
        head2.next.next.next.next.next = new Node(10000000);
        List<Node> list = new ArrayList<>();
        list.add(head1);
        list.add(head2);
        list.add(head3);

 // printLinkedList(merge(head1,head2));
        //printLinkedList(mergeKLists(list));
       Node mergebydivideandconquer = mergebydivideandconquer(list, 0, list.size() - 1);
        printLinkedList(mergebydivideandconquer);


    }
//合并k个排序链表，并且返回合并后的排序链表。尝试分析和描述其复杂度。
    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }

        System.out.println();
    }
//好好理解一下heap  这种多路合并 排序或者 求最大最小


    //nlogk  n是总共的数  k是几个链表  因为heap中最多有k个数    heap调整是logk的  k是heap的大小
    public static Node mergebyheap(List<Node> list) {   //边界条件很重要  list装的是头
        if (list == null || list.size() == 0) {
            return null;
        }
        PriorityQueue<Node> heap = new PriorityQueue<>(list.size(), ListNodeComparator);

        for (Node head : list) {
            heap.offer(head);
        }

        Node dummy = new Node(0);
        Node tail = dummy;

        while (heap.size()!=0) {
            Node head = heap.poll();
            tail.next = head;
            tail = head;
            if (head != null) {
                heap.offer(head.next);
                //head=head.next;   这个head 不是某一个链表的head  二十 这个heap 每次拿出来一个都叫head
            }
        }
        return dummy.next;
    }

    private static Comparator<Node> ListNodeComparator = new Comparator<Node>() { //第一个减第二个参数  升序
        public int compare(Node left, Node right) {
            return left.value - right.value;
        }
    };

    public static Node mergeKLists(List<Node> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }

        Queue<Node> heap = new PriorityQueue<Node>(lists.size(), ListNodeComparator);
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }

        Node dummy = new Node(0);
        Node tail = dummy;
        while (!heap.isEmpty()) {
            Node head = heap.poll();
            tail.next = head;
            tail = head;
            if (head.next != null) {
                heap.add(head.next);
            }
        }
        return dummy.next;
    }
//合并k个排序链表，并且返回合并后的排序链表
//    public static Node MergeKSortedLists(List<Node> )
    //归并排序的思想
    public static Node mergebydivideandconquer(List<Node> list, int left, int right) {
        if (left == right) {
            return list.get(left);
        }

        int mid = (left + right) / 2;
        Node node = mergebydivideandconquer(list, left, mid);
        Node node1 = mergebydivideandconquer(list, mid + 1, right);
        return merge(node, node1);
    }

    public static Node merge(Node head, Node head1) {
        Node dummy = new Node(0);
       Node newnode = dummy;
        while (head != null && head1 != null) {     //下面的if改成else就可以省掉两个判断
            if (head.value <= head1.value) {
                newnode.next = head;
                head = head.next;
            } else {         //写成两个if  容易空指针  你在 while条件了防止了空指针 但是链表走不到头  所以要用if else
                newnode.next = head1;
                head1 = head1.next;
            }
            newnode = newnode.next;

        }
        while (head != null) {
            newnode.next = head;
            newnode = newnode.next;
            head = head.next;
        }
        while (head1 != null) {
            newnode.next = head1;
            newnode = newnode.next;
            head1 = head1.next;
        }
        return dummy.next;

    }
    public static Node mergesortedlisttwobytwo(List<Node> list){

        for (int i = 0; i < list.size()-1; i++) {
            Node node = list.get(i);
            Node node1 = list.get(i+1);
            Node merge = merge(node, node1);
            list.set(i+1,merge);
        }


        return null;

    }

}
