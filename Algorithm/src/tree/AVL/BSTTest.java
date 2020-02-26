package tree.AVL;

public class BSTTest {

    public static void main(String[] args) {

        int[] arr = new int[]{8,9,6,7,5,4};
        Bsttree bsttree = new Bsttree();

        for (int i : arr) {

            bsttree.add(new Bstnode(i));
        }
        int height = bsttree.height();
        System.out.println(height);
        System.out.println(bsttree.root.data);
        //bsttree.midshow();
        //  Bstnode rearsch = bsttree.rearsch(10);
        // System.out.println(rearsch);
        // System.out.println("--------------------");
        //Bstnode presearch1 = bsttree.presearch1(9);
        // System.out.println(presearch1.data);//这一步最好卸载类里面 修改 不然需要在这里修改 不好ava.lang.NullPointerException at tree.AVL.BSTTest.main(BSTTest.java:20)
//bsttree.delete(9);
//bsttree.deleteone(10);
        // bsttree.deletetwo(10);
        //bsttree.midshow();

    }
}
