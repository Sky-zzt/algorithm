package tree;

public class LowestCommonAncestor {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
//// 在root为根的二叉树中找A,B的LCA:
//    // 如果找到了就返回这个LCA
//    // 如果只碰到A，就返回A
//    // 如果只碰到B，就返回B
//    // 如果都没有，就返回null
    }

    //宏观的看
    public static Node CommonAncester(Node root,Node node,Node node1){
        if (root == null || root == node || root == node1) {  //宏观的想成一个节点 两个节点的情况 请勿深想
            return root;
        }
        Node left = CommonAncester(root.left,node,node1);
        Node right = CommonAncester(root.right,node,node1);
        if (left!=null&&right!=null){
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
      return null;






    }
}
