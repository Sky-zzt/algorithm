package tree;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Arrays;

public class SubtreewithMaximumAverage {
 // ArrayList<String> strings =  new ArrayList<String>();

    public static class Node {
        public long value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        head.left.left.right = new Node(7);
        Node f = f(head);
        System.out.println(f.value);


    }

    //给一棵二叉树，找到有最大平均值的子树。返回子树的根结点。
    static class ResultType {
        long size;
        long sum;

        public ResultType(long size, long sum) {
            this.size = size;
            this.sum = sum;
        }
    }
 private static ResultType maxsubtree=new ResultType(Integer.MIN_VALUE,1);


    private static Node subtree1 = null;

    public static ResultType maxaverage(Node root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        ResultType left = maxaverage(root.left);
        ResultType right = maxaverage(root.right);
        ResultType result = new ResultType(left.size + right.size + 1, left.sum + right.sum + root.value);

        if (subtree1 == null) {//先给这俩赋值 不然就空指针了  过长得到||语句 分成两个if写 容易理解
            maxsubtree = result;
            subtree1 = root;

        }
        if (result.sum / result.size > maxsubtree.sum / maxsubtree.size) {
            maxsubtree = result;
            subtree1 = root;
        }
        return result;

    }

    public static Node f(Node root) {
        ResultType maxaverage = maxaverage(root);
        return subtree1;
    }


//=============================================================================
    //这个刚好
    //不能 定义为 node 和maxavg 因为啊 左子树返回的avg 和右子树返回的avg  无法得到这个树的avg
//对比 MinimumSubtree  为了 返回 node  不得不写两个 函数  或者 用全局变量
    private Node subtree = null;
    // private ResultType subtreeResult = null;   //用下面这个好理解    删除 原有106行的if判断语句
    private  ResultType subtreeResult=new ResultType(Integer.MIN_VALUE,1);

    /**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
    public Node findSubtree2(Node root) {
        helper(root);
        return subtree;
    }

    private ResultType helper(Node root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        // 分治法计算左右子树的平均值
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        // 当前subtree的结果是左右两颗子树的和的平均值加上自身
        ResultType result = new ResultType(           //求以每个点为根的子树的z最大avg

                left.sum + right.sum + root.value,
                left.size + right.size + 1
        );
        // 打擂台比较得到最大平均值的子树
        if (subtreeResult.sum * result.size < result.sum * subtreeResult.size) {
            subtree = root;
            subtreeResult = result;
        }
        return result;
    }
}
