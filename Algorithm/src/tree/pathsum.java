package tree;

public class pathsum {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    /*
    给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。
     */
    //是否存在一个pathsum==k
    //xie分治的时候思考一下 一个节点的情况
    public static boolean path(Node root,int K){
        /*
         if (root==null&&K!=0){
            return false;
        }
        if (root ==null&&K==0){
            return true;
            不行  输入[]0 就不行了
         */
        if (root==null){
            return false;
        }
        if (root.left ==null&&root.right==null){
            return K==root.value;

        }
        boolean path = path(root.left,K-root.value);
        boolean path1 = path(root.right,K-root.value);

        return path||path1;



    }





}
