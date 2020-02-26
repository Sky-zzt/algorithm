package tree.thread;

public class ThreadedBinaryNode {
    int data;
    ThreadedBinaryNode rightnode;
    ThreadedBinaryNode leftnode;
    int lefttype;
    int righttype;

    public void setRightnode(ThreadedBinaryNode rightnode) {
        this.rightnode = rightnode;
    }

    public void setLeftnode(ThreadedBinaryNode leftnode) {
        this.leftnode = leftnode;
    }

    public ThreadedBinaryNode(int data) {
        this.data = data;
    }

}
