package Test;

public class panduanyouhuan {

     static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }

    }
    public static boolean havehuan(Node head){
         Node current=head;
         if (head==null){
             return false;
         }
         if (head!=null&&head.next==null){
             return false;
         }
         if (head.next.next==null&&head.next!=null){
             return false;
         }
        Node next1 = head.next;         //跟着head变  每次next，next都是差一啊  傻逼
        Node next2 = head.next.next;
         while (next1!=null&&next1.next.next!=null&&next2.next.next!=null){
           //  Node next = head.next;         //跟着head变  每次next，next都是差一啊  傻逼
            // Node next1 = head.next.next;
        //     head=head.next;
             next1=next1.next;
             next2=next2.next.next;
             if (next2==next1){
                 return true;
             }
         }
        return false;
    }



    public static void deletenode(Node head,int k){
         if (head==null){
             return;
         }
         Node prenode=null;
        Node replace=null;
         if (head.value==k){

             head.next=replace;
             head.next=null;
            head= replace;
             return;
         }

         while (replace.value!=k){
             prenode=head;
             head=head.next;
         }
         prenode.next=head.next;

    }
    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static  void insert(Node head,Node node,int k){
         Node prenode=null;
         while (head.value!=k+1){
             prenode=head;
             head=head.next;
         }
         node.next=prenode.next;
         prenode.next=node;





    }

    public static void main(String[] args) {

        Node head1 = new Node(0);
        Node head2 = new Node(1);
        head1.next = head2;
        head1.next.next = new Node(2);
     //  head1.next.next.next = head2;
       head1.next.next.next= new Node(3);
       head1.next.next.next.next= new Node(4);
       head1.next.next.next.next.next= new Node(5);
       head1.next.next.next.next.next.next= new Node(6);
       head1.next.next.next.next.next.next.next= new Node(7);
       head1.next.next.next.next.next.next.next.next= new Node(8);
     //  head1.next.next.next.next= head2;
      //  head1.next.next.next.next.next =head2;
        printLinkedList(head1);
        System.out.println(hasCycle(head1));
      ///  Node node = new Node(100);
       // deletenode(head1,1);
        //insert(head1,node,5);
//printLinkedList(head1);

    }
    public static  boolean hasCycle(Node head) {
        // write your code here
        if (head==null){
            return false;
        }
        if (head!=null&&head.next==null){
            return false;
        }
        if (head.next.next==null&&head.next!=null){
            return false;
        }
        Node next1 = head;
        Node next2 = head;
        while (next1!=null&&next1.next!=null&&next2.next!=null&&next2.next.next!=null){//biji
            next1=next1.next;
            next2=next2.next.next;
            if (next2==next1){
                return true;
            }
        }
        return false;
    }
}

