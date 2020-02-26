package tree.thread;

public class Threadtreetest {
    ThreadedBinaryNode pre=null;
    ThreadedBinaryNode p=null;
    public   void threadnode(ThreadedBinaryNode node){//中序线索化
        if(node==null){
            return;
        }
        threadnode(node.leftnode);
        if (node.leftnode==null){
            node.leftnode=pre;
            node.lefttype=1;
        }
        if (pre!=null&&pre.rightnode==null){
            pre.rightnode=node;
            pre.righttype=1;

        }
        pre=node;

        threadnode(node.rightnode);


    }
    public ThreadedBinaryNode Preresarchmidnode(ThreadedBinaryNode node){//
        if(node.lefttype==1){

            p=node.leftnode;
        }else {
        for (p=node.leftnode;p.righttype==0;p=p.rightnode){


        }}



        return p;

    }


    public static void main(String[] args) {
        Threadtree threadtree = new Threadtree();
        ThreadedBinaryNode root= new ThreadedBinaryNode(1);
        ThreadedBinaryNode binaryTree2 = new ThreadedBinaryNode(2);
        ThreadedBinaryNode binaryTree3 = new ThreadedBinaryNode(3);
        ThreadedBinaryNode binaryTree4 = new ThreadedBinaryNode(4);
        ThreadedBinaryNode binaryTree5 = new ThreadedBinaryNode(5);
        threadtree.setRoot(root);
        root.setLeftnode(binaryTree2);
        root.setRightnode(binaryTree3);
        binaryTree2.setRightnode(binaryTree4);
        binaryTree3.setRightnode(binaryTree5);

        Threadtreetest threadtreeteat = new Threadtreetest();
        threadtreeteat.threadnode(root);
   threadtree.threaditeratere();//遍历线索二叉树
        //System.out.println(root.data);
        //ThreadedBinaryNode preresarchmidnode = threadtreeteat.Preresarchmidnode(binaryTree5);
       // System.out.println(preresarchmidnode.data);


    }

}
