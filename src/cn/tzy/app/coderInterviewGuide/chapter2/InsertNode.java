package cn.tzy.app.coderInterviewGuide.chapter2;

/**
 * Created by tuzhenyu on 17-8-14.
 * @author tuzhenyu
 */
public class InsertNode {
    public static void insert(Node head,int value){
        Node node = new Node(value);
        Node pre = head;
        Node cur = head.next;
        Node next ;
        while (cur!=head){
            next = cur.next;
            if (cur.value==value){
                pre.next = node;
                node.next = cur;
                return;
            }
            pre = cur;
            cur = next;
        }
        if(head.value==value){
            pre.next = node;
            node.next = cur;
        }
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node1;
        Node head = node1;

        insert(head,1);

        Node cur = head.next;
        while (cur!=head){
            System.out.print(cur.value);
            cur = cur.next;
        }
    }
}
