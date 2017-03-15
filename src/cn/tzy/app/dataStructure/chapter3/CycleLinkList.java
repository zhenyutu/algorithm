package cn.tzy.app.dataStructure.chapter3;

/**
 * Created by tuzhenyu on 17-3-14.
 * @author tuzhenyu
 */
public class CycleLinkList<E>{
    private int size;
    public Node head;
    public Node current;

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

    public CycleLinkList(){
        this.size = 0;
        Node header = new Node(null);
        this.head = header;
        this.current=header;
        this.head.next = this.head;
    }

    public void add(E e){
        current.next=new Node(e);
        current=current.next;
        current.next=head;
        size++;
    }

    public void insert(int index,E e)throws Exception{
        if (index<0||index>size)
            throw new Exception("索引错误");
        Node cur = head;
        for (int i=0;i<index;i++){
            cur = cur.next;
        }
        Node tmpNode = cur.next;
        cur.next=new Node(e);
        cur.next.next = tmpNode;
        size++;
    }

    public void delete(int index)throws Exception{
        if (index<0||index>size)
            throw new Exception("索引错误");
        Node cur = head;
        for (int i=0;i<index;i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }

    public Node get(int index)throws Exception{
        if (index<0||index>size)
            throw new Exception("索引错误");
        Node cur = head.next;
        for (int i=0;i<index;i++){
            cur = cur.next;
        }
        return cur;
    }

    public int length(){
        return size;
    }
    public boolean isEmpty(){
        return this.current==this.head;
    }
}
