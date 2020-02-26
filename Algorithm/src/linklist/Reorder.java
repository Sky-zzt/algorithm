package linklist;

public class Reorder {
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

    public static Node findMiddle(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        Node head2 = new Node(6);
        head2.next = new Node(5);
        head2.next.next = new Node(4);
     ///   head2.next.next.next.next.next = new Node(6);
     //   reoder(head1);
        printLinkedList(mer(head1,head2));

    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void merge(Node head1, Node head2) {  //不好返回    记一下
        int index = 0;
        Node dummy = new Node(0);  //这个dummy秒的很
        while (head1 != null && head2 != null) {
            if (index % 2 == 0) {
                dummy.next = head1;
                head1 = head1.next;
                dummy = dummy.next;
                index++;
            } else {
                dummy.next = head2;
                head2 = head2.next;
                dummy = dummy.next;
                index++;
            }

        }
        if (head1 != null) {
            dummy.next = head1;
        } else {
            dummy.next = head2;
        }
    }

    public static Node merge1(Node head, Node head1) {
        int index = 0;
        Node dummy = new Node(0);
        dummy.next = head;
        Node curr = null;
        Node curr1 = null;
        curr = head;
        /*
        while (curr!=null&&head1!=null) {
           // curr1=head1;
            head.next = head1;
            curr = curr.next;
            head1 = head1.next;
        }
            而且head=head1后    后面全是head1的东西
        head 始终没有变 curr变了而已
         */
        while (curr != null && head1 != null) {
            // curr1=head1;
            head.next = head1;
            curr = curr.next;
            head = curr;
            head1 = head1.next;
        }
        return dummy.next;
    }

    public static void reoder(Node head) {
        if (head == null || head.next == null) {
            return;
        }
//mid=head  他俩指向了同一个地址 并没有开辟
        Node mid = findMiddle(head);
        Node reverseList = reverseList(mid.next);
        mid.next = null;

        merge(head, reverseList);


    }

    public static Node mer(Node head1, Node head2) {
        Node next = null;
        Node dummy = new Node(0);
        dummy.next = head1;
        while (head1 != null && head2 != null) {
            next = head1.next;
            head1.next = head2;
            head1 = next;
            head2 = head2.next;
        }
        return dummy.next;
    }
}
