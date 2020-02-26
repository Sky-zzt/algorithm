package linklist;

import javax.print.attribute.standard.NumberUp;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CopyListwithRandomPointer {
    public static class RandomListNode {
        public int label;
        public RandomListNode next;
        public RandomListNode random;

        public RandomListNode(int data) {
            this.label = data;
        }
    }

    public static void main(String[] args) {
//        RandomListNode head1 = new RandomListNode(-1);
//
//        head1.next = new RandomListNode(8);
//        head1.next.next = new RandomListNode(7);
//        head1.next.next.next = new RandomListNode(3);
//        head1.next.next.next.next = new RandomListNode(4);
//        head1.random= head1.next.next.next.next;
//        head1.next.next.next.next.random=head1;
//        head1.next.next.next.next.next = new RandomListNode(6);
        //printLinkedList(copyr);
        printLinkedList(copyRandomList1(null));

    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode current = head;
        RandomListNode current1 = head;
        RandomListNode newhead1 = null;  //没必要用这么多  学会 变量复用
        RandomListNode newhead2 = null;
        RandomListNode newhead3 = null;
        while (head != null) {
            map.put(head, new RandomListNode(head.label));
            head = head.next;
        }
        RandomListNode newhead = map.get(current);
        newhead1 = newhead;
        while (current != null) {
            newhead = map.get(current);
            //   newhead1 = newhead; 放这里每次都被重新赋值 就找不到头了
            newhead.next = map.get(current.next);
            newhead = newhead.next;
            current = current.next;
        }
        newhead2 = newhead1;
        newhead3 = newhead2;
        int label = Integer.MAX_VALUE;
        while (current1 != null) {
            if (current1.random != null) {
                label = current1.random.label;
            } else {
                current1 = current1.next;
                newhead2 = newhead2.next;
                continue;
            }
            while (newhead1 != null) {
                if (newhead1.label == label) {
                    newhead2.random = newhead1;
                }
                newhead1 = newhead1.next;
            }
            newhead2 = newhead2.next;
            newhead1 = newhead3;
            current1 = current1.next;
        }
        return newhead3;
    }

    //学习这个写法 很好的答案
    public static RandomListNode copyRandomList2(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = head;//复用他  不用在 弄个新变量了
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static RandomListNode copyRandomList1(RandomListNode head) {
        RandomListNode cur = head;
        RandomListNode next = null;
        RandomListNode res = null;

        //生成节点
        while (cur != null) {
            next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        //链接
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;

        }
        cur = head;
        //  cur.next=res;   //你把cur.next指向空了  动脑子啊   好多次 都前后写反   。。。。。。。。
        res = cur;
        RandomListNode res1 = res;  //此时head next 用不到了  也可以服用一下 为了易读 还是算了
        //split
        while (cur != null) {
            res.next = cur.next;
            res = res.next;//别忘了写
            cur = cur.next.next;

        }
        return res1.next;


    }


    public static void printLinkedList(RandomListNode head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.label + " ");
            head = head.next;
        }
        System.out.println();
    }

}
