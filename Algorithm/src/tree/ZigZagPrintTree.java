package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagPrintTree {
     public static class Node {
             public int value;
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
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right=new Node(7);

        zigzagLevelOrder1(head);
    }
//很好的方法  和题目  建议下次 在写一遍
    //也可以  层序遍历完之后，看层数，偶数层reverse一下即可。

    //体会 利用normalOrder  和交换stack的用法
    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }

        Stack<Node> currLevel = new Stack<Node>();
        Stack<Node> nextLevel = new Stack<Node>();
        Stack<Node> tmp;

        currLevel.push(root);
        boolean normalOrder = true;

        while (!currLevel.isEmpty()) {
           ArrayList<Integer> currLevelResult = new ArrayList<Integer>();

            while (!currLevel.isEmpty()) {
             //   ArrayList<Integer> currLevelResult = new ArrayList<Integer>();

                Node node = currLevel.pop();
                System.out.print(node.value+",");
                currLevelResult.add(node.value);

                if (normalOrder) {
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                }
            }

            result.add(currLevelResult);
            tmp = currLevel;
            currLevel = nextLevel;
            nextLevel = tmp;
            normalOrder = !normalOrder;
        }

        return result;


    }

    //
    public static void zigzagLevelOrder1(Node root){
         if (root==null){
             return;
         }
        Stack<Node> curr = new Stack<>();
        Stack<Node> next = new Stack<>();
        Stack<Node> tmp ;
        curr.add(root);
        boolean normalseq=true;
        while (!curr.isEmpty()) {         //null  isEmpty不一样   list可以add（nuu）  所以取元素一定要判空


            while (!curr.isEmpty()) {

                Node pop = curr.pop();
                System.out.print(pop.value);
                if (!normalseq) {
                    if (pop.right != null) {
                        next.add(pop.right);
                    } if (pop.left!=null){
                        next.add(pop.left);
                    }
                } else {
                    if (pop.left != null) {
                        next.add(pop.left);
                    }
                    if (pop.right != null) {
                        next.add(pop.right);
                    }
                }
            }
            normalseq = !normalseq;
            tmp = curr;
            curr = next;
            next = tmp;
        }

    }

    public static void zigzag(Node root){
        if (root==null){
            return;
        }
        Stack<Node> curr = new Stack<>();
        Stack<Node> next = new Stack<>();
        Stack<Node> tmp ;
        curr.add(root);
        boolean normalseq=true;
      while (!curr.isEmpty()){
          while (curr!=null){
              System.out.println(curr.pop());
              if (normalseq){
                  if (curr.pop()!=null){
                      next.add(curr.pop().left);
                      next.add(curr.pop().right);
                  }
              }else {
                  if (curr.pop()!=null){
                      next.add(curr.pop().left);
                      next.add(curr.pop().right);
                  }
              }
          }
          normalseq = !normalseq;
          tmp = curr;
          curr = next;
          next = tmp;
      }



    }

}
