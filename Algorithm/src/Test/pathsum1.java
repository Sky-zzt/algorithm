package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class pathsum1 {
 public static class Node {
         public int value;
         public Node left;
         public Node right;

         public Node(int data) {
             this.value = data;
         }
     }

public static List<List<Integer>> path(Node root, int target){
     if (root==null){
         return null ;
     }
    List<List<Integer>> list = new ArrayList<>();
    ArrayList<Integer> arrayList = new ArrayList<>();
    helper(root,target,arrayList,list);
    return list;

}

    private static void helper(Node root,int target,ArrayList<Integer> arrayList,List<List<Integer>> list) {

     arrayList.add(root.value);
     //递归结束条件
     if (target==0&&root.left==null&&root.right==null){  //如果不限制以叶子节点作为结束  可以 去掉 后面两个root.left==null&&root.right==null
         list.add(new ArrayList<>(arrayList));
     }

     helper(root.left,target-root.value,arrayList,list);
     helper(root.right,target-root.value,arrayList,list);
     arrayList.remove(arrayList.size()-1);



    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.left.left = new Node(5);
        head.left.left.left.left = new Node(6);
    }
}
