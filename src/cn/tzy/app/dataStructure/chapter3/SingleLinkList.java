package cn.tzy.app.dataStructure.chapter3;

/**
 * Created by tuzhenyu on 17-3-14.
 * @author tuzhenyu
 */
public class SingleLinkList<E>{
    private int size;
    public Node first;

    public static class Node<E>{
        private E e;
        public Node next;

        public Node(E e){
            this.e = e;
        }
        public E getElement(){
            return this.e;
        }
    }

    public SingleLinkList(){
        this.size = 0;
        this.first = null;
    }

    public void add(E e){
        Node oldFirst = first;
        this.first = new Node(e);
        first.next = oldFirst;
        size++;
    }

    public void insert(int index,E e)throws Exception{
        if (index<0||index>size)
            throw new Exception("索引错误");
        Node current = first;
        for (int i=0;i<index-1;i++){
            current = current.next;
        }
        Node tmpNode = current.next;
        current.next=new Node(e);
        current.next.next = tmpNode;
        size++;
    }

    public void delete(int index)throws Exception{
        if (index<0||index>size)
            throw new Exception("索引错误");
        Node current = first;
        for (int i=0;i<size-1-index;i++){
            current = current.next;
            System.out.println(current.getElement());
        }
        current.next = current.next.next;
        size--;
    }

    public Node get(int index)throws Exception{
        if (index<0||index>size)
            throw new Exception("索引错误");
        Node current = first;
        for (int i=0;i<index;i++){
            current = current.next;
        }
        return current;
    }

    public int length(){
        return size;
    }
    public boolean isEmpty(){
        return first==null;
    }
}
