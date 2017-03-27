package cn.tzy.app.algorithm.chapter1;

import java.util.Iterator;

/**
 * Created by tuzhenyu on 17-3-26.
 * @author tuzhenyu
 */
public class FixedCapacityStack<Item> implements Iterable<Item>{
    private int capacity;
    private int size;
    private Item[] stack;

    public FixedCapacityStack(int capacity){
        this.capacity = capacity;
        this.stack = (Item[]) new Object[capacity];
        this.size = 0;
    }

    public void push( Item item) throws Exception{
        if (this.capacity - this.size > 0){
            stack[size] = item;
            size++;
        }else {
            throw new Exception("栈空间不足！");
        }
    }

    public Item pop()throws Exception{
        if (!isEmpty()){
            size--;
            Item tmp = stack[size];
            stack[size] = null;
            return tmp;
        }else {
            throw new Exception("栈空间为空!");
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Iterator<Item> iterator(){
        return new StackIterator();
    }

    private class StackIterator implements Iterator{
        private int i = size;
        public boolean hasNext(){
            return i>0;
        }
        public Item next(){
            return stack[--i];
        }
    }
}
