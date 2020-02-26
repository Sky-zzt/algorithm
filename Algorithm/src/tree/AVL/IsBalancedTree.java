package tree.AVL;

public class IsBalancedTree {
//每个节点左子树和右子树的差小于2
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    static class returndata {

        public boolean isbalance;
        public int h;
//主函数
        public returndata(boolean isbalance, int h) {
            this.isbalance = isbalance;
            this.h = h;
        }
    }
/*
去每个节点 看他的右子树是否平衡，左子树是否平衡 不平衡 返回false，
平衡则返回这个两个子树的高度 看 高度差是否大于1
 */

    public static returndata process1(Node head) {//经典题

        if (head == null) {
            return new returndata(true, 0);
        }
        returndata process = process1(head.left);
        if (!process.isbalance) {
            return new returndata(false, 0);
        }
        returndata process1 = process1(head.right);
        if (!process1.isbalance) {
            return new returndata(false, 0);
        }
        if (Math.abs(process.h - process1.h) > 1) {
            return new returndata(false, 0);
        }
        return new returndata(true,Math.max(process.h,process1.h)+1);
    }

public static boolean isB(Node head){

        return process1(head).isbalance;
}
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isB(head));

    }
    /*
    1.想这个分治函数要干啥 ：他要判断是否为balanceTree => 左子树平衡 右子树平衡 整体平衡，三个条件缺一不可
    ||那就先判断左右子树是否平衡然后判断整体是否平衡||整体平衡是不是需要知道左右子树的高度呢=》那就在左右子树都平衡情况下
    返回左右子树的高度
    2.他需要那些参数进行返回//函数要啥我返回啥  要左右子树的高度 那就返回

     */

    static class ResultType{
        boolean IsBalace;
        int level;

        public ResultType(boolean isBalace, int level) {
            IsBalace = isBalace;
            this.level = level;
        }
    }
    public static ResultType process(Node root){
        if (root==null) {
            return new ResultType(true, 0);
        }
            ResultType left = process(root.left);
            ResultType right = process(root.right);


        // subtree not balance
        if (!left.IsBalace|| !right.IsBalace) {
            return new ResultType(false, -1);
        }

        // 整体是否平衡
        if (Math.abs(left.level - right.level) > 1) {
            return new ResultType(false, -1);
        }
//函数要啥我返回啥  要左右子树的高度 那就返回  //没有左右子树的高度 我怎么呢判平衡
        return new ResultType(true, Math.max(left.level, right.level) + 1);

        }
        public static boolean isBalance(Node root){

            ResultType process = process(root);
            return process.IsBalace;

        }

}
