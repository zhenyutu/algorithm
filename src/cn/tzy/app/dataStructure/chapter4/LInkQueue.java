package cn.tzy.app.dataStructure.chapter4;

/**
 * Created by tuzhenyu on 17-3-16.
 * @author tuzhenyu
 */
public class LInkQueue<E> {
    private int size;
    Node front;
    Node rear;

    public class Node<E>{
        E e;
        Node next;

        public Node(E e){
            this.e = e;
            this.next=null;
        }
    }

    public LInkQueue(){
        this.size=0;
        Node header = new Node(null);
        this.front=header;
        this.rear=header;
    }

    public void enQueue(E e){
        rear.next= new Node(e);
        rear = rear.next;
        size++;
    }

    public E deQueue(){
        Node tmp = front.next;
        front.next=front.next.next;
        size--;
        return (E)tmp.e;
    }

    public E getTop(){
        return (E)front.next.e;
    }

    public int length(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }
}
