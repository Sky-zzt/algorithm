package day01;

public class Loopnode {
    int data;
    Loopnode next=this;

    public Loopnode(int data) {
        this.data = data;
    }

    public void insert(Loopnode node){
        node.next=this.next;
        this.next=node;
    }

    public static void main(String[] args) {
        Loopnode loopnode1 = new Loopnode(1);
        Loopnode loopnode2 = new Loopnode(2);
        Loopnode loopnode3 = new Loopnode(3);
        Loopnode loopnode4 = new Loopnode(4);
        loopnode1.insert(loopnode2);
        loopnode2.insert(loopnode3);
        loopnode3.insert(loopnode4);
        System.out.println(loopnode1.data);
        System.out.println(loopnode2.data);
        System.out.println(loopnode3.data);
        System.out.println(loopnode4.data);
        System.out.println(loopnode4.next.data);
    }

}
