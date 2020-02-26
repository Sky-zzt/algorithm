package tree;

public class Node {
    int data;
    Node rightnode;
    Node leftnode;

    public void setRightnode(Node rightnode) {
        this.rightnode = rightnode;
    }

    public void setLeftnode(Node leftnode) {
        this.leftnode = leftnode;
    }

    public Node(int data) {
        this.data = data;
    }

    public void frontshow() {

        System.out.println(data);
        if (leftnode != null) {
            leftnode.frontshow();
        }
        if ((rightnode != null)) {
            rightnode.frontshow();

        }

    }

    public void midshow() {

        if (leftnode != null) {
            leftnode.midshow();

        }
        System.out.println(data);

        if (rightnode != null) {

            rightnode.midshow();

        }

    }

    public Node frontsearch(int i) {///////zhege这个查查  很好 逻辑清楚
        Node node = null;
        if (this.data == i) {
            return this;
        }
        if (leftnode != null) {

            node = leftnode.frontsearch(i);

        }
        if (node != null) {///////zhege这个查查 这句
            return node;
        }

        if (rightnode != null) {
            node = rightnode.frontsearch(i);
        }
        return node;

    }

    public boolean search(int i,Node head) {//  错的这个  前序查找  建议  在自己思考写一遍  我以开始写成挨个遍历了
    //
        return true;
    }

    public void delete(int i) {
        //    Node parent=this;

        if (this.leftnode != null && this.leftnode.data == i) {
            this.leftnode = null;
            return;
        }

        if (this.rightnode != null && this.rightnode.data == i) {
            this.rightnode = null;
            return;
        }
        // parent=leftnode;
        if (this.leftnode != null) {
            this.leftnode.delete(i);
        }
        //  parent=rightnode;
        if (this.rightnode != null) {
            this.rightnode.delete(i);
        }


    }


}
