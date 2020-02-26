package linklist;

public class test  {
    public static class node extends ReverseList.Node{
        int val;
        node next;
        public node(int a){
          this.  val=a;
        }
    }

    public static void main(String[] args) {
        ReverseList.printLinkedList(new node(1));
    }

}
