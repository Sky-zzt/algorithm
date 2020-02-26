package tree.bst;

import java.util.*;

public class IsBSTAndCBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    //左子树比他小  右子树比他大  搜索二叉树
    /*
    AVL树本质上还是一棵二叉搜索树，它的特点是：
1.本身首先是一棵二叉搜索树。
2.带有平衡条件：每个结点的左右子树的高度之差的绝对值（平衡因子）最多为1。
也就是说，AVL树，本质上是带了平衡功能的二叉查找树（二叉排序树，二叉搜索树）
     */

    public static void ff(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        ff(root.left, list);
        list.add(root.value);
        ff(root.right, list);

    }

    public static boolean f1(Node root) {
        if (root == null) {
            return true;
        }
        ArrayList<Integer> list = new ArrayList<>();
        ff(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            /*
     不能写成 if (list.get(i) >= list.get(i + 1)) {
                return false;

            } else {
                return true;
            }
            因为。。
             */
            if (list.indexOf(i) < list.indexOf(i + 1)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isBST(Node head) {//是bst就是中序遍历升序  然后呢  用中序非递归遍历可以改 判断是否升序
        if (head == null) {
            return true;
        }
        boolean res = true;
        Node pre = null;
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
            if (pre != null && pre.value > cur1.value) {
                res = false;
            }
            pre = cur1;
            cur1 = cur1.right;
        }
        return res;
    }

    /*
    判断是否为完全二叉树
  按层遍历
  1.任何一个节点有右没有左子树  返回false
  2.如果不是左右子树双全  则后面的必须是叶节点 否则返回false


     */

    public static boolean isCBT1(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<Node>();
        boolean leaf = false;//阶段
        Node l = null;
        Node r = null;
        queue.offer(head);
        //这个过程 就是判断是不是 cbt 不是就返回false  否则就执行完跳出来 return true
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            //如果我开启了这个阶段 即此时leaf为true 左右必须为叶子节点
            if ((leaf && (l != null || r != null))) {
                return false;
            }
            if (l == null && r != null) { //两种情况都有了
                return false;
            }
            if (l != null) {   //先装左子树 在右子树
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
                //什么时候开启
            }
            if ((l != null && r == null) || (l == null && r == null)) {
                leaf = true;
            }
        }
        return true;
    }


    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.left = new Node(1);
        head.right = new Node(2);
//        head.left.left = new Node(1);
//        head.left.right = new Node(3);
//        head.right.left = new Node(5);
        System.out.println(f1(head));
//        printTree(head);
//        System.out.println(isBST(head));
//        System.out.println(isCBT1(head));

    }
}