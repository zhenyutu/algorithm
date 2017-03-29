package cn.tzy.app.algorithm.chapter1;

import java.util.Iterator;

/**
 * Created by tuzhenyu on 17-3-27.
 * @author tuzhenyu
 */
public class LinkedQueue<Item> implements Iterable<Item>{
    private Node first;
    private Node last;
    private int size;

    class Node{
        Item item;
        Node next;

        Node(Item item){
            this.item = item;
        }
    }

    public LinkedQueue(){
        first = null;
        last = null;
        size = 0;
    }

    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node(item);
        last.next = null;
        if (isEmpty()){
            first = last;
        }else {
            oldLast.next = last;
        }
        size++;
    }

    public Item dequeue()throws Exception{
        Item item = null;
        if (!isEmpty()){
            item = first.item;
            first = first.next;
            size--;
        }else {
            throw new Exception("队列为空！");
        }

        return item;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public Iterator<Item> iterator(){
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item>{
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
