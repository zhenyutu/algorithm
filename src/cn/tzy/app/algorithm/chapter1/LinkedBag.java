package cn.tzy.app.algorithm.chapter1;

import java.util.Iterator;

/**
 * Created by tuzhenyu on 17-3-29.
 * @author tuzhenyu
 */
public class LinkedBag<Item> implements Iterable<Item>{
    private Node first;
    private int size;

    class Node{
        Item item;
        Node next;

        public Node(Item item){
            this.item = item;
        }
    }

    public LinkedBag(){
        this.first = null;
        this.size = 0;
    }

    public void add(Item item){
        Node temp = first;
        first = new Node(item);
        first.next = temp;
        size++;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public Iterator<Item> iterator(){
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item>{
        Node current = first;
        public boolean hasNext(){
            return current != null;
        }

        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
