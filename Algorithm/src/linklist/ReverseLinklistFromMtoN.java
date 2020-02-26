package linklist;

import java.security.PublicKey;

public class ReverseLinklistFromMtoN {
    public static void main(String[] args) {
ReverseList.Node head1 = new ReverseList.Node(1);
        head1.next = new ReverseList.Node(2);
        head1.next.next = new ReverseList.Node(3);
        head1.next.next.next = new ReverseList.Node(4);
        head1.next.next.next.next= new ReverseList.Node(5);
        head1.next.next.next.next.next = new ReverseList.Node(6);
        printlinklist(head1);
        ReverseList.Node head = reverselinstfrommton(head1, 1, 5);
        System.out.println();

        printlinklist(head);
    }
    public static ReverseList.Node reverselinstfrommton(ReverseList.Node head, int m, int n ){
        ReverseList.Node prehead=null;
        ReverseList.Node modifylis_tail=null;
        ReverseList.Node newhead=null;
        ReverseList.Node next;
        ReverseList.Node result=head;
        int changelen=n-m+1;
        while (head!=null&&m>1){
            prehead=head;
            head=head.next;
           // modifylis_tail=head;必须放在外面
           m--;
        }
        modifylis_tail=head;
        while (head!=null&&changelen>0){
              next=head.next;
              head.next=newhead;
              newhead=head;
              head=next;
            changelen--;
         }
        modifylis_tail.next=head;
        if (prehead!=null){
            prehead.next=newhead;
        }else {
            result=newhead;
        }
        return result;

    }
    public static void printlinklist(ReverseList.Node head){
        while (head!=null){
            System.out.print(head.value+" ");
            head=head.next;
        }

    }

}
