package Test;

public class reversefrommtoN {
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
        Node head1 = new Node(1);
        head1.next = new Node(2);
       head1.next.next = new Node(3);
       head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        Node node = reversefromMtoN(head1, 1, 5);
        printLinkedList(node);
        // printLinkedList(head1);


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

    public static Node reversefromMtoN(Node head, int m, int n) {
        if (m<1||n>5){
            return head;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        Node mcurrent = dummy;
        Node premcurrent = null;
        Node ncurrent = dummy;
        Node prencurrent = null;
        for (int i = 0; i < m; i++) {
            premcurrent = mcurrent;
            mcurrent = mcurrent.next;

        }
        for (int i = 0; i <= n; i++) {
            prencurrent = ncurrent;
            ncurrent = ncurrent.next;
        }
        prencurrent.next = null;
        Node pre = reverseList(mcurrent);
        premcurrent.next =prencurrent;
        mcurrent.next = ncurrent;

        return dummy.next;
    }
}
