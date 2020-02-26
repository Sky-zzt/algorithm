package linklist;

public class RemoveDuplicatesfromSortedList {

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
        Node head1 = new Node(0);
        head1.next = new Node(1);
        head1.next.next = new Node(1);

        head1.next.next.next = new Node(2);
        head1.next.next.next.next = new Node(3);
      //  head1.next.next.next.next.next = new Node(2);
        // head1.next.next.next.next .next.next= new Node(516);
//deletenode(head1,2);
        printLinkedList(deleteDuplicates(head1));
      //  printLinkedList(partion(head1, 10));
      //  printLinkedList(sortedlinklist(head1));
        //  printLinkedList(deletenode(head1, 1));
        // printLinkedList(deletesamenode(head1));
        //  Node deletesamenode = deletesamenode(head1);
        //   System.out.println(deletesamenode.value);
        //   printLinkedList(deletesamenode(head1));

    }/*
    笔记:


     */

    public static Node deletenode(Node head, int K) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        Node prenode = dummy;

        while (head != null) {
            //    prenode = head;  think yixai
            if (head.value == K) {
                prenode.next = head.next;
                head = head.next;//这两个必须加 不然只能删除不重复节点  用if else啊

                continue;
            }
            head = head.next;
            prenode = prenode.next;

        }

        return dummy.next;
    }

    public static Node partion(Node head, int K) {
        if (head == null) {
            return null;
        }
        Node leftdummy = new Node(0);
        Node left = leftdummy;
        Node rightdummy = new Node(0);
        Node right = rightdummy;
        while (head != null) {
            if (head.value < K) {
                left.next = head;
                left = left.next; //.这样会有head 后面的

                //     left.next=null;  相当于把head 整空了

            } else {
                right.next = head;
                right = right.next;

            }
            head = head.next;
        }
        //  right.next=null;  //不加这句 存在首位相连成环的可能性
        left.next = rightdummy.next;


        return leftdummy.next;
    }

    public static Node deletesamenode(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        {
            ;
            ;
        }
        Node prenode = dummy;
        Node newhead1 = null;
        while (prenode != null && prenode.next != null) {
            if (prenode.value == prenode.next.value) {
                Node newhead = deletenode(dummy, prenode.value);
                newhead1 = deletenode(dummy, prenode.next.value);
            }
            // System.out.println(dummy.value);
            prenode = prenode.next;

        }
        return newhead1.next;
    }

    public static Node sortedlinklist(Node head) {
        Node middleNext=null;
        Node middle = findMiddle(head);
        middle.next=middleNext;
        middle.next=null;
        if (head==null||head.next==null){
            return head;
        }
        sortedlinklist(head.next);
        sortedlinklist(middleNext);
        Node merge = merge(head, middleNext);
        return merge;
    }
    public Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = findMiddle(head);

        Node right = sortList(mid.next);
        mid.next = null;
        Node left = sortList(head);

        return merge(left, right);
    }



    public static  Node findMiddle(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public   static  Node merge(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }

        return dummy.next;
    }
/////////////////zz再写一遍
    public static Node deleteDuplicates(Node head) {
        // write your code here
        if (head==null){
            return null;
        }
        Node dummy  =    new Node(Integer.MAX_VALUE);
        dummy.next=head;
        Node pre=dummy;


        while(head!=null&&head.next!=null){
            if(head.value==head.next.value){

                while(head.next!=null&&head.value==head.next.value){  //一直找到所有的相等的节点  然后 pre.next=head.next;
                    head=head.next;
                }
                pre.next=head.next;
                head=head.next;

            }else{
                head=head.next;
                pre=pre.next;
            }

        }
        return dummy.next;

    }
}
