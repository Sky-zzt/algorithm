package tree;

public class IsBSTByDivideAndConquer {
    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
// 类比判别是否为balancetree  这个的策略就是 看  左子树的最大值和右子树的最小值的比较
    class ResultType {
        boolean is_bst;
        int maxValue, minValue;

        ResultType(boolean is_bst, int maxValue, int minValue) {
            this.is_bst = is_bst;
            this.maxValue = maxValue;
            this.minValue = minValue;
        }
    }


    public boolean isValidBST(Node root) {
        ResultType r = validateHelper(root);
        return r.is_bst;
    }

    private ResultType validateHelper(Node root) {
        if (root == null) {
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        ResultType left = validateHelper(root.left);
        ResultType right = validateHelper(root.right);

        if (!left.is_bst || !right.is_bst) {
            // if is_bst is false then minValue and maxValue are useless
            return new ResultType(false, 0, 0);
        }

        if (root.left != null && left.maxValue >= root.value ||
                root.right != null && right.minValue <= root.value) {
            return new ResultType(false, 0, 0);
        }

        return new ResultType(true,
                Math.max(root.value, right.maxValue),
                Math.min(root.value, left.minValue));
    }

static class re{
        int max;
        int min;
        boolean IsBst;

    public re(int max, int min, boolean isBst) {
        this.max = max;
        this.min = min;
        IsBst = isBst;
    }
}
    public static re f(Node root){
        if (root==null){
            return new re(Integer.MIN_VALUE,Integer.MAX_VALUE,true);
        }
        re left = f(root.left);
        re right = f(root.right);
        if (!left.IsBst&&!right.IsBst){
            return  new re(0,0,false);
        }
        //跟root比
        /*
          if (root.left != null && left.maxValue >= root.value ||
                root.right != null && right.minValue <= root.value) {
            return new ResultType(false, 0, 0);
        }
         */
        if (left.max<right.min){
            return new re(0,0,false);
        }
        //跟root比
        /*
          Math.max(root.value, right.maxValue),
                Math.min(root.value, left.minValue));
         */
        return  new re(Math.max(left.max,right.max),Math.min(left.min,right.min),true);


    }


    //这种方法 你就没办法返回了

    /*

    class ResultType{
        boolean isValidBST;
        int lval;
        int rval
        public ResultType(boolean isValidBST,int lval,int rval){
            this.isValidBST=isValidBST;
            this.lval=lval;
            this.rval=rval;
        }
    }
    public boolean isValidBST(TreeNode root) {
        // write your code here


    }
    public ResultType helper(TreeNode root){
        if(root==null){
            return new ResultType(True,0,0);
        }
        ResultType left  =helper(root.left);
        ResultType right = helper(root.right);
        if(left.isValidBST==false||right.isValidBST==false){
            return new ResultType(false,0);
        }
        if(left.level>root.level||right.level<root.level){
            return new ResultType(false,0);
        }
        return new ResultType(True,left.) //


                */
    //这种方法 你就没办法返回了
}
