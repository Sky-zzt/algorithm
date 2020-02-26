package linklist;

import org.omg.CORBA.PUBLIC_MEMBER;

public class ReverseList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }

        public Node() {

        }
    }

    public static Node reverseList(Node head) { //反转链表
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;//保存下一个  不然更换指向后就丢了
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node reverselist(Node head) { // 递归
        if (head == null || head.next == null) {
            return head;
        }
        //	Node next=null;
        Node next = head.next;

        head.next = null;

        Node re = reverselist(next);
        //head.next=head;
        next.next = head;


        return re;
    }

    public static Node reversefromMtoN(Node head, int m, int n) {  //两两反转
        for (int i = 1; i < m - 1; i++) {
            head = head.next;
        }
        Node h1 = head;

        for (int i = m; i < n; i++) {
            head = head.next;
        }
        Node h2 = head;
        h1.next = h2;
        return null;


    }

    public static Node twotworeverse(Node head) {
Node next=null;
        while (head != null && head.next != null && head.next.next != null) {
           next=head.next.next;
           head.next.next=head;
           head.next=next;
           head=next;
        }
        return null;

    }

    public static class DoubleNode {
        public int value;
        public DoubleNode pre;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    public static DoubleNode reverseList(DoubleNode head) {
        DoubleNode prenode = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prenode;
            head.pre = next;//多了这个 记住就行了
            prenode = head;
            head = next;
        }
        return prenode;
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printDoubleLinkedList(DoubleNode head) {
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.pre;
        }
        System.out.println();
    }

    public static Node re(Node head, int m, int n) {
        int mm=m;
        Node head3 = head;
        if (m==1){
            //需要考虑两个边界
        }
        while (m - 2> 0) {
            head = head.next;
            m--;
        }
        Node head1 = head;
        int h = n-mm+1;
        while (h > 0) {
            head = head.next;
            h--;
        }
        Node head2 = head;
         Node next1=head1.next;
         head1.next=null;
        Node next2 = head2.next;
        head2.next = null;
        Node reverseList = reverseList(next1);
        head1.next = reverseList;
        while (true) {
            if (reverseList.next == null) {
                break;
            }
            reverseList = reverseList.next;
        }
        reverseList.next = next2;
        return head1;
    }
    public static Node reverse(Node head){
        Node pre=null;
        Node next=null;
        while (head!=null){
         //  pre=head;
           next=head.next;
            head.next=pre;
            pre=head;
            head=next;


        }
        return pre;
    }
    public static Node deletenode(Node head,int K){
        if (head==null){
            return null;
        }
        Node dummy = new Node(0);
        dummy.next=head;
        Node prenode=null;
       while (dummy.value!=K){
          prenode=dummy;
           dummy=dummy.next;
       }
       prenode.next=dummy.next;
        return dummy.next;
    }
    public static  Node swapPairs(Node head) {
        //递归出口
        if(head == null || head.next == null)
            return head;
        //每组相邻节点的第二个节点
        Node newNode = head.next;
        //每组相邻节点的第一个节点的next指针指向下一组已反转的第一个节点
        Node swapPairs = swapPairs(head.next.next);
        head.next=swapPairs;
        //每组相邻节点的第二个节点的next指针指向改组的第一个节点
        newNode.next = head;
        return newNode;
    }
    public static  Node swapPairs1(Node head,Node next ) {

        //Node next=null;
        if (head.next==null||head.next.next==null){
            return head;
        }
        next=head.next.next;
        head.next.next=head;
        head.next=swapPairs1(next,next);
        head=next;
        return head;

    }

    /**
     * 长达200字的递归笔记在此等你
     * @param head
     * @return
     */
    public static Node reverseByrecursion(Node head){
        if (head==null||head.next==null){
            return head;
        }
        Node swapparis = reverseByrecursion(head.next);
        head.next.next=head;
        head.next=null;
       //swapparis.next.next=swapparis;
       //swapparis.next=null;
        return swapparis;


    }
 

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
  //    head1.next.next.next = new Node(4);
    //    head1.next.next.next.next = new Node(5);
     //  head1.next.next.next.next.next = new Node(6);
        printLinkedList(head1);
        printLinkedList(swapPairs(head1));
       //printLinkedList(reverse(head1));
 //    printLinkedList(twotworeverse(head1));
      //  Node node = new Node(0);
     //   printLinkedList(swapPairs1(head1,node));

       // printLinkedList(deletenode(head1,1));
       // Node head = re(head1, 1, 4);
        // head1 = reverseList(head1);
       // printLinkedList(head1);

//		DoubleNode head2 = new DoubleNode(1);
//		head2.next = new DoubleNode(2);
//		head2.next.pre = head2;
//		head2.next.next = new DoubleNode(3);
//		head2.next.next.pre = head2.next;
//		head2.next.next.next = new DoubleNode(4);
//		head2.next.next.next.pre = head2.next.next;
//		printDoubleLinkedList(head2);
//		printDoubleLinkedList(reverseList(head2));

    }

    public static Node swapparisanExampleOfWrong(Node head1) {
/*\
下面这个head1 始终没变 死循环
 */
        if (head1==null||head1.next==null||head1.next.next==null){
            return head1;
        }
        Node newNode = head1;
        head1.next.next=newNode;//成环了
        Node swapparis = swapparisanExampleOfWrong(head1.next.next);

        head1.next=null;
        return swapparis;
    }
    public static Node swapparis(Node head1) {

        if (head1==null||head1.next==null||head1.next.next==null){
            return head1;
        }
        Node newNode = head1.next;
       // head1.next.next=newNode;
        Node swapparis = swapparis(head1.next.next);


        head1.next=null;
        return swapparis;
    }

    public static void reverseDouble(DoubleNode head){
        if (head==null){
            return;
        }
        DoubleNode pre=null;
        DoubleNode next=null;
        while (head!=null){
            next=head.next;
            head.next=pre;
            head.pre=next;
            pre=head;
            head=next;
        }


    }
}
