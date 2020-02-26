package linklist;

public class Rotate {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }

        public Node() {

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
      //  head1.next = new Node(2);
      //  head1.next.next = new Node(3);
      //  head1.next.next.next = new Node(4);
//     //   head1.next.next.next.next.next = new Node(6);
        printLinkedList(rotate(head1,1));

    }
    public static Node rotate(Node head ,int K){
        if (head==null){
            return null;
        }
        Node dummy = new Node(0);
        Node clonecurrent=null;
        dummy.next=head;
        Node current=head;
        Node precurr=head;
        if (head.next==null){
            return head;
        }
        int j=0;
        while (head!=null){
            head=head.next;
            j++;
            if (K>=j){
                return dummy.next;
            }
        }

        for (int i = 1; i <=j-K; i++) {
            precurr=current;
            current=current.next;
        }
        clonecurrent=current;  //思考这样做的意义
        while (current.next!=null){
            current=current.next;
        }
        precurr.next=null;
        current.next=head;
        return clonecurrent;
    }
}
