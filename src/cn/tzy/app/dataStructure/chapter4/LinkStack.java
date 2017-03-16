package cn.tzy.app.dataStructure.chapter4;

/**
 * Created by tuzhenyu on 17-3-16.
 * @author tuzhenyu
 */
public class LinkStack<E> {
    private int size;
    private Node top;

    public class Node<E>{
        E e;
        Node next;

        public Node(E e){
            this.e = e;
        }
    }

    public LinkStack(){
        this.size=0;
        this.top = null;
    }

    public void push(E e){
        Node tmp = top;
        top = new Node(e);
        top.next = tmp;
        size++;
    }

    public E pop(){
        Node tmp = top;
        top = top.next;
        size--;
        return (E)tmp.e;
    }

    public E getTop(){
        return (E)top.e;
    }

    public int length(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }
}
