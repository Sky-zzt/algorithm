package tree.AVL;

public class Bsttree {
    Bstnode root;

    public void setRoot(Bstnode root) {
        this.root = root;
    }

    public void add(Bstnode bstnode) {

        if (root == null) {
            root = bstnode;

        } else {
            root.add(bstnode);
        }
    }

    public void midshow() {

        root.midshow();
    }

    public Bstnode rearsch(int i) {

        Bstnode bstnode = root.reasch(i);
        return bstnode;

    }

    public Bstnode presearch1(int i) {

        Bstnode presearch = root.presearch(i);
        return presearch;
    }
//bst的删除  三种情况
    public void delete(int i) {

        Bstnode bstnode1 = root.reasch(i);
        if (bstnode1 == null) {
            return;
        }
        Bstnode bstnode = root.presearch(i);
        if (bstnode == null) {
            return;
        }
        if (bstnode1.rightnode == null && bstnode1.rightnode == null) {
            if (bstnode.leftnode == bstnode1) {
                bstnode.leftnode = null;
            } else if (bstnode.rightnode == bstnode1) {
                bstnode.rightnode = null;

            }

        }
    }

    public void deleteone(int i) {

        Bstnode reasch = root.reasch(i);
        Bstnode presearch = root.presearch(i);
        if (reasch == null) {
            return;
        }
        if ((reasch.rightnode != null)) {
            presearch.rightnode = reasch.rightnode;

        } else if (reasch.leftnode != null) {
            presearch.leftnode = reasch.leftnode;
        }
        delete(i);
    }

    public void deletetwo(int i) {//删除带有两个子节点的节点，我们把该节点后继做为删除节点的值
        Bstnode rearsch = rearsch(i);
        if (rearsch == null) {
            return;
        }

        int deleterightmin = deleterightmin(rearsch.rightnode);

        rearsch.data = deleterightmin;
    }


    public int deleterightmin(Bstnode bstnode) {
        while (bstnode.leftnode != null) {

            bstnode = bstnode.leftnode;
        }
        deleteone(bstnode.data);
        return bstnode.data;

    }

    public int height() {
        return root.height();
    }

}
