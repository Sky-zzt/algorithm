package tree;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

public class MaxPathSum {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    public static int pathsum(Node root) { //root to leaf
        if (root == null) {
            return 0;
        }
        int left = pathsum(root.left);
        int right = pathsum(root.right);
        return Math.max(left, right) + root.value;
    }

    /*
   想明白这个递归要干啥 他要收集啥信息
    */
    public static int rootToany(Node root) {  //他要收集每个节点开始的pathsum
        if (root == null) {  //  如果要求是叶子节点结束的话，需要加 root.left==null and root.right==null
            return 0;
        }
        int left = rootToany(root.left);
        int right = rootToany(root.right);
        return Math.max(Math.max(left, right), 0) + root.value;  //
    }

    //给出一棵二叉树，寻找一条路径使其路径和最大，路径可以在任一节点中开始和结束（路径和为两个节点之间所在路径上的节点权值之和）
    static class ResultType {
        int rootToany;
        int AnyToAny;

        public ResultType(int rootToany, int anyToAny) {
            this.rootToany = rootToany;
            AnyToAny = anyToAny;
        }
    }

    public static ResultType AnyToAny(Node root) {
        if (root == null) {
            return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        ResultType left = AnyToAny(root.left);
        ResultType right = AnyToAny(root.right);
        int rootToAny = Math.max(0, Math.max(left.rootToany, right.rootToany)) + root.value;
        int anyToAny = Math.max(left.AnyToAny, right.AnyToAny);
        anyToAny = Math.max(anyToAny, Math.max(0, left.rootToany) + Math.max(0, right.rootToany) + root.value);
        return new ResultType(rootToAny, anyToAny);
    }

    public static ResultType anytoany(Node root) {
        if (root == null) {
            return null;
        }

        ResultType left = anytoany(root.left);
        ResultType right = anytoany(root.right);
        int rootToany = Math.max(0, Math.max(left.rootToany, right.rootToany))+root.value;


        int any2any = Math.max(left.AnyToAny, right.AnyToAny);  //左子树或者右子树 去max
        any2any = Math.max(any2any, Math.max(0, left.rootToany) + Math.max(0, right.rootToany) + root.value);//最大值取root 左子树的root2any+右子树的root2any
        return new ResultType(rootToany,any2any);

    }

    /*
    给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

    说明: 叶子节点是指没有子节点的节点。
     */
    public static List<List<Integer>> pathSum(Node root, int sum) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<List<Integer>> list = new ArrayList<>();

        helper(root, sum, arrayList, list);
        return null;
    }

    public static void helper(Node root, int sum,
                              ArrayList<Integer> arrayList,
                              ArrayList<List<Integer>> list) {
        if (root == null) {
            return;
        }
        arrayList.add(root.value);
        if (sum == 0 && root.left == null && root.right == null) {
            list.add(arrayList);
        }
        helper(root.left, sum - root.value, arrayList, list);
        helper(root.right, sum - root.value, arrayList, list);
        list.remove(list.size() - 1);


    }
}
