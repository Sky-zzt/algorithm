package Test;

import java.util.HashMap;
import java.util.List;

public class LRU {
    public static void main(String[] args) {
        NodeDoubleLinkedList<Integer> list = new NodeDoubleLinkedList<>();
        Node<Integer> node = new Node<>(1);
        Node<Integer> node1 = new Node<>(2);


        list.addNode(node);
        list.addNode(node1);
        list.addNode(new Node<>(3));
        list.addNode(new Node<>(4));
        list.moveNodeToTail(node);
      //  printDoubleLinkedList(list.head);
        mycache<String, Integer> mycache = new mycache<>(3);


    }
    public static void printDoubleLinkedList(Node head) {
        System.out.print("Double Linked List: ");
        Node end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.Last;
        }
        System.out.println();
    }
    public static class Node<V> {
        V value;
        Node<V> Last;
        Node<V> next;

        public Node(V value) {
            this.value = value;
        }
    }

    public static class NodeDoubleLinkedList<V> {
        private Node<V> head;
        private Node<V> tail;

        public NodeDoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void addNode(Node<V> node) {
            if (node == null) {
                return;
            }
            if (tail == null) {
                tail = node;
                head = node;
            } else {
                tail.next = node;
                node.Last = tail;
                tail = node;
            }
        }
        public void moveNodeToTail(Node<V> node){
            if (this.tail == node) {
                return;
            }
            if (node==head){  //不要忘记了 把 head.next 赋值给next
               head=node.next;
                node.next.Last=null;
                node.next=null;
                tail.next=node;
                node.Last=tail;

            }else {  //还应该把 让head的下一个为head
                node.Last.next=node.next;
                node.next.Last=node.Last;
                tail.next=node;
                tail=node;
            }


        }
        public Node<V> removeHead(){
            if (head==null){

                return null;
            }
            if (head==tail){
                head=null;
                tail=null;
            }     //不对 还应该把 让head的下一个为head
           Node<V> res =this.head;

            head.next.Last=null;
            head.next=null;
            head=res.next;
            return head;
        }



        }
   public static class mycache<K,V>{
        private final HashMap<K,Node<V>> keynode;
        private NodeDoubleLinkedList nodelist;
        private final HashMap<Node<V>,K> nodekey;
        private final int capacity;

        public mycache(int capacity){
            if (capacity<1){
                System.out.println("不合法");
            }
            this.capacity=capacity;
            this.keynode = new HashMap<K,Node<V>>();
            this.nodekey=new HashMap<Node<V>,K>();
       }
       public V get(K key){
            if (this.keynode.containsKey(key)) {
                Node<V> node = keynode.get(key);
                nodelist.moveNodeToTail(node);
                return node.value;
            }
            return null;
       }
       public void set(K key,V value) {
            if (keynode.containsKey(key)){
                Node<V> node = keynode.get(key);
                node.value=value;
                nodelist.moveNodeToTail(node);
            }else {
                keynode.put(key,new Node<V>(value));
                nodekey.put(new Node<V>(value),key);
                nodelist.addNode(new Node<V>(value));
                if (nodekey.size()==capacity+1){
                    removeMostUnusedCache();
                }
            }
       }

     /*
       //为什么不直接用 map get 和set 然后控制size呢 还用双向链表
       因为 一旦 超过size 想要remove mostunused的node时  你怎们在hashmap里知道哪个
       是最不常用的  就算 你知道 你也不容易在O1时间内remove掉
       而nodelist 每次set get 操作 就已经把最不常用放到head了  直接remove即可

      */
       private void removeMostUnusedCache(){
            //想要remove掉 keynode中的node  必须知道key
            //此时nodekey 就用上了

           Node node = nodelist.removeHead();
           K key = nodekey.get(node);
           keynode.remove(key);
           nodekey.remove(node);



       }

   }
















    public static class Mycache<K,V>{
        private HashMap<K, Node<V>> keyNodeMap;
        private HashMap<Node<V>, K> nodeKeyMap;
        private NodeDoubleLinkedList nodeList;
        private int capacity;

        public Mycache(int capacity){
            if (capacity<1){
                System.out.println("It is iligael");
            }
            this.keyNodeMap = new HashMap<K,Node<V>>();
            this.nodeKeyMap=new HashMap<Node<V>,K>();

        }

        public V get(K key){
            if (keyNodeMap.containsKey(key)){
                Node<V> value = keyNodeMap.get(key);
                nodeList.moveNodeToTail(value);
                return value.value;
            }
            return  null;
        }
        public void set(K key,V value){
            if (keyNodeMap.containsKey(key)){
                Node<V> node = keyNodeMap.get(key);
                node.value=value;
                nodeList.moveNodeToTail(node);
            }else {
                keyNodeMap.put(key,new Node<>(value));
                nodeList.addNode(new Node(value));
                nodeKeyMap.put(new Node<>(value),key);
                if (keyNodeMap.size()==capacity+1){
                    removeMostUnusedCache();
                }
            }
        }
        private  void removeMostUnusedCache(){
            Node removeHead = nodeList.removeHead();
            K key = nodeKeyMap.get(removeHead);
            nodeKeyMap.remove(removeHead);
            keyNodeMap.remove(key);
        }
    }


}
