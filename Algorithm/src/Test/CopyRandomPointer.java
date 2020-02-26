package Test;

import java.util.HashMap;

public class CopyRandomPointer {
    public static class RandomListNode {
        public int label;
        public RandomListNode next;
        public RandomListNode random;

        public RandomListNode(int data) {
            this.label = data;
        }
    }

    public static void main(String[] args) {



    }
    public static RandomListNode copy(RandomListNode head){
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while (head!=null){
            map.put(head,new RandomListNode(head.label));
        }

        while (head!=null) {
            map.get(head).random =  map.get(head.random);
            map.get(head).next =  map.get(head.next);
            head=head.next;
        }
        return map.get(head);
    }
    public static RandomListNode copy1(RandomListNode head){
        ////1->1'->2->2'->3->3'->null
        while (head!=null){

           RandomListNode newhead=head.next;
           head.next=new RandomListNode(head.label);
           head.next.next=newhead;
            head=newhead;
        //   newhead.next=
        }
        while (head!=null){
            if (head.random!=null){

            }
           RandomListNode h=head.next;
           h.random=head.random.next;
           head=head.next.next;

        }
        while (head!=null){
            RandomListNode next = head.next;
            next.next=next.next.next;
        }

        return null;
    }
}
