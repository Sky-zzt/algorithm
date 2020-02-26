package linklist;

import linklist.PrintCommonPart;

public class PrintCommonPartDIY {
    public static void main(String[] args) {  //无序的我这个也行
        PrintCommonPart.Node node1 = new PrintCommonPart.Node(2);
        node1.next = new PrintCommonPart.Node(3);
        node1.next.next = new PrintCommonPart.Node(5);
        node1.next.next.next = new PrintCommonPart.Node(6);

        PrintCommonPart.Node node2 = new PrintCommonPart.Node(1);
        node2.next = new PrintCommonPart.Node(2);
        node2.next.next = new PrintCommonPart.Node(5);
        node2.next.next.next = new PrintCommonPart.Node(7);
        node2.next.next.next.next = new PrintCommonPart.Node(8);

        printLinkedList(node1);
        printLinkedList(node2);
        printcommonpart(node1, node2);
    }

    public static void printcommonpart(PrintCommonPart.Node node1, PrintCommonPart.Node node2) {
        PrintCommonPart.Node head=node2;


            while (node1 != null&&head!=null) {
                if (node1.value == head.value) {
                    System.out.println(node1.value);
                    head = node2;
                    node1=node1.next;
                }else {
                    head = head.next;
                  if (head == null){
                        node1=node1.next;
                      head = node2;
                    }

                }


            }
      //    head=node2;
         //   node1 = node1.next;


    }

    public static void printLinkedList(PrintCommonPart.Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

}
