package day01;

public class Node {
    int data;
    Node next;


    public Node(int data) {
        this.data = data;
    }

    public void app(Node node) {

        Node currentnode = this;
        while (true) {
            Node nextnode = currentnode.next;
            if (nextnode == null) {
                break;
            }
          currentnode=nextnode;
        }
        currentnode.next=node;
    }
    public Node next(){
        return this.next;
    }
    public boolean islast(){
        return next==null;
    }
    public void removenext(){

        Node next = this.next.next;
        this.next=next;
    }
    public void show(){
        Node currnode=this;
       while (true){

           System.out.println(currnode.data);
            currnode = currnode.next;
            if(currnode==null){
                break;
            }


       }
    }
    public void insert(Node node){
        node.next=this.next;
        this.next=node;


    }



    public static void main(String[] args) {
        Node node1 = new Node(142);
        Node node2 = new Node(1622);
        Node node3 = new Node(162);
        Node node4= new Node(152);
        Node node5= new Node(148782);
        node1.app(node2);
        node1.app(node3);
        node1.app(node4);
        node2.insert(node5);
        node1.show();
       // node1.removenext();
       // System.out.println("=======");
      //  node1.show();
       // int data = node1.data;
       //int data = node1.next.next.next.data;

       // boolean islast111 = node1.islast();
       // boolean islast1111 = node4.islast();
      //  System.out.println(islast1111);


    }
}
