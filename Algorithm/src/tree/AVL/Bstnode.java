package tree.AVL;


public class Bstnode {
    int data;
    Bstnode leftnode;
    Bstnode rightnode;

    public Bstnode() {
    }

    public Bstnode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    //bst insert
    public void add(Bstnode bstnode) {
        if (bstnode == null) {
            return;
        }
        if (bstnode.data < this.data) {
            if (this.leftnode == null) {
                this.leftnode = bstnode;
            } else {
                this.leftnode.add(bstnode);
            }
        } else {

            if (this.rightnode == null) {
                this.rightnode = bstnode;
            } else {
                this.rightnode.add(bstnode);
            }
        }//左旋转 左左  右旋转变成-2
        if (leftheight() - rightheight() >= 2) {
            rightrotate();
        }


    }

    public int leftheight() {

        if (leftnode == null) {
            return 0;
        }
        return leftnode.height();
    }

    public int rightheight() {

        if (rightnode == null) {
            return 0;
        }
        return rightnode.height();
    }

    private void rightrotate() {
        Bstnode newright = new Bstnode(data);
        newright.rightnode = rightnode;
        newright.leftnode = leftnode.rightnode;
        data = leftnode.data;
        leftnode = leftnode.leftnode;
        rightnode = newright;
    }

    public void midshow() {
        Bstnode node = this;
        if (node.leftnode != null) {
            node.leftnode.midshow();
        }
        System.out.println(data);
        if (rightnode != null) {
            node.rightnode.midshow();
        }
    }

//BST 查
    public Bstnode reasch(int i) {
        if (this.data == i) {
            return this;
        } else if (i < this.data) {
            if (leftnode != null) {
                return leftnode.reasch(i);
            }

        } else if (i > this.data) {
            if (rightnode != null) {
                return rightnode.reasch(i);
            }

        }
        return null;
    }

    /*else{
        System.out.println("这个不会被执行，因为一个if会匹配一个else 这两个只会执行一个  不会执行两个else");
   }

   }*/
    public Bstnode presearch(int i) {
        if (this == null) {
            return null;
        } else if (this.leftnode != null && this.leftnode.data == i || this.rightnode != null && this.rightnode.data == i) {
            return this;
        } else if (this.data > i && this.leftnode != null) {
            return this.leftnode.presearch(i);
        } else if (this.data < i && this.rightnode != null) {
            return this.rightnode.presearch(i);
        }


        return null;
    }

    public int height() {//当前树的高度

        return Math.max(leftnode == null ? 0 : leftnode.height(), rightnode == null ? 0 : rightnode.height()) + 1;
    }

}