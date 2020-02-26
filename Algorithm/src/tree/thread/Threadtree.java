package tree.thread;

public class Threadtree {
    ThreadedBinaryNode root;

    public void setRoot(ThreadedBinaryNode root) {
        this.root = root;
    }


    public void threaditeratere() {

ThreadedBinaryNode node=root;
while (node!=null){
    while (node.lefttype==0){
        node=node.leftnode;
    }
    System.out.println(node.data);

    while (node.righttype==1){
        node=node.rightnode;
        System.out.println(node.data);
    }
    node=node.rightnode;
}

    }
}
