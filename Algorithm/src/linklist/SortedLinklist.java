package linklist;

import arrary.MinSubarray;

public class SortedLinklist {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {

            this.value = data;
        }
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(-1);
       head1.next = new Node(10);
    head1.next.next = new Node(4);
   // head1.next.next.next=hea
 //  head1.next.next.next = new Node(10000);
    // head1.next.next.next.next = new Node(8);
     //  head1.next.next.next.next.next = new Node(0);
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
       head2.next.next.next = new Node(10);
       head1.next.next.next=head2;
      //  head2.next.next.next.next = new Node(15);
      //  head2.next.next.next.next.next = new Node(32);
        //printLinkedList(head1);
         // printLinkedList(findmiddle(head1));
          //printLinkedList(findMiddle(head1));
   //    printLinkedList(merge(head1, head2));
      printLinkedList(sortedlist(head1));


    }
    public static  Node findMiddle(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
//归并的思想
    public static Node sortedlist(Node head) {

        if (head==null||head.next==null){ //head.next==null的有 防止一个节点引起的空指针
            return head;
        }
        Node mid = findMiddle(head);// 对与两个节点的的时候  不能切分了   因为在切分 没有意义了   head会死循环
      //mo=mid.next=
        Node m=mid.next;
        mid.next=null;
        Node right = sortedlist(head);
        Node left = sortedlist(m);

        return merge(left,right);



    }

    public static Node findmiddle(Node head) {
        Node QuickPointer = head;
        Node SlowPointer = head;
        if (head.next==null){
            return head;
        }
        if (head.next.next==null){
            return head.next;
        }

        while (QuickPointer != null && QuickPointer.next != null) {
            QuickPointer = QuickPointer.next.next;
            SlowPointer = SlowPointer.next;
        }
        return SlowPointer;

    }

    public static Node merge(Node head, Node head1) {
        Node newnode = null;
        Node dummy = new Node(0);
        newnode = dummy;
        {
            newnode.next=head;
            head=head.next;
            newnode=newnode.next;


        }
        while (head != null && head1 != null&&head!=null&&head1!=null) {     //下面的if改成else就可以省掉两个判断
            if (head.value <= head1.value) {

                newnode.next = head;

                head = head.next;
            }
            else   {         //写成两个if  容易空指针  你在 while条件了防止了空指针 但是链表走不到头  所以要用if else
                newnode.next = head1;

                head1=head1.next;
            }
            newnode = newnode.next;

        }
        while (head != null) {
            newnode.next = head;
            newnode=newnode.next;
            head = head.next;
        }
        while (head1 != null) {
            newnode.next = head1;
            newnode=newnode.next;
            head1 = head1.next;
        }
        return dummy.next;

    }}

