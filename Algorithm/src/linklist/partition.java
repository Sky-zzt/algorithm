package linklist;

import Sort.BucketSort;

public class partition {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }

        public Node() {

        }
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
        //  right.next=null;  //不加这句 存在首位相连成环的可能性   1 2 9 3  如果没有 right.next=null
        //那么  左 1 2 3  右 9  9 还连着3 就成环了
        left.next = rightdummy.next;


        return leftdummy.next;
    }












    public static Node partition(Node head,int target){
            if (head== null){
                return null;
            }
        Node leftdummy = new Node(0);
        Node left = leftdummy;
        Node rightdummy = new Node(0);
        Node right = rightdummy;
        while (head!=null){
            if (head.value<target){
                left.next=head;
                left=left.next;
            }else {
                right.next=head;
                right=right.next;
            }
            head=head.next;
        }
        right.next=null;//
        left.next=rightdummy.next;
return leftdummy.next;

    }


}
