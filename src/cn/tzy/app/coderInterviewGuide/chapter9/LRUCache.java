package cn.tzy.app.coderInterviewGuide.chapter9;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuzhenyu on 18-1-11.
 * @author tuzhenyu
 */
class Node<V>{
    public V value;

    Node pre = null;
    Node next = null;

    public Node(V v){
        this.value = v;
    }
}

class LinkedDoubleList<V>{
    private Node head;
    private Node tail;

    public LinkedDoubleList(){
        head = null;
        tail = null;
    }

    public void addNode(Node<V> node){
        if (node==null)
            return;
        if (head==null) {
            head = node;
            tail = node;
        }else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
    }

    public void moveNodeTail(Node<V> node){
        if (node==head){
            head = head.next;
            head.pre = null;
        }else if (node==tail){
            return;
        }else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        tail.next = node;
        node.pre = tail;
        tail = node;
        tail.next = null;
    }

    public Node<V> removeHead(){
        if (head==null)
            return null;
        Node<V> res = head;
        if (head==tail){
            head = null;
            tail = null;
        }else {
            head = head.next;
            head.pre = null;
            res.next = null;
        }

        return res;
    }
}
public class LRUCache<K,V> {
    private Map<K,Node<V>> keyNodeMap;
    private Map<Node<V>,K> nodeKeyMap;
    private LinkedDoubleList list;
    private int capacity;

    public LRUCache(int capacity){
        this.keyNodeMap = new HashMap<>();
        this.list = new LinkedDoubleList();
        this.capacity = capacity;
    }

    public V get(K key){
        if (keyNodeMap.containsKey(key)){
            Node<V> node = keyNodeMap.get(key);
            list.moveNodeTail(node);
            return node.value;
        }

        return null;
    }

    public void set(K key,V value){
        if (keyNodeMap.containsKey(key)){
            Node<V> node = keyNodeMap.get(key);
            list.moveNodeTail(node);
            node.value = value;
        }else {
            Node<V> node = new Node<V>(value);
            keyNodeMap.put(key,node);
            nodeKeyMap.put(node,key);
            list.addNode(node);
            if (this.keyNodeMap.size()==this.capacity+1){
                removeMostUnuseCache();
            }
        }
    }

    private void removeMostUnuseCache(){
        Node<V> node = list.removeHead();
        K key = this.nodeKeyMap.get(node);
        this.keyNodeMap.remove(key);
        this.nodeKeyMap.remove(node);
    }

}
