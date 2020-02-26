package Test;

import linklist.ReverseList;

public class reverse {
    public static void main(String[] args) {
        ReverseList.Node head1 = new ReverseList.Node(1);
        head1.next = new ReverseList.Node(2);
        head1.next.next = new ReverseList.Node(3);
        printLinkedList(head1);
        head1 = reverseList(head1);
        printLinkedList(head1);
    }
    public static void printLinkedList(ReverseList.Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static ReverseList.Node reverseList(ReverseList.Node head){

        ReverseList.Node next;
        ReverseList.Node newhead=null;
        while (head!=null){

            next=head.next;
            head.next=newhead;
            newhead=head;

            head=next;
        }
        return newhead;
    }
}
