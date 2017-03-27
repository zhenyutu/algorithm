package cn.tzy.app.algorithm.chapter1;

import java.util.Iterator;

/**
 * Created by tuzhenyu on 17-3-27.
 * @author tuzhenyu
 */
public class LinkedStack<Item> implements Iterable<Item>{
    private Node first;
    private int size;

    class Node{
        Item item;
        Node next;

        Node(Item item){
            this.item = item;
        }
    }

    public LinkedStack(){
        this.first = null;
        this.size = 0;
    }

    public void push(Item item){
        Node node = new Node(item);
        node.next = first;
        first = node;
        size++;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int length(){
        return size;
    }

    public Iterator<Item> iterator(){
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item>{
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
