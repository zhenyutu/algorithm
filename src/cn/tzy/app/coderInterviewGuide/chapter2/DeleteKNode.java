package cn.tzy.app.coderInterviewGuide.chapter2;

/**
 * Created by tuzhenyu on 17-7-27.
 * @author tuzhenyu
 */
public class DeleteKNode {
    public static void deleteSingleNodes(Node head,int k){
        Node node1 = head;
        Node node2 = head;

        for (int i=0;i<k;i++){
            node1 = node1.next;
        }

        while (node1.next!=null){
            node1 = node1.next;
            node2 = node2.next;
        }

        node2.next = node2.next.next;
    }

    public static void deleteDoubleNodes(Node head,int k){
        
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
        Node head = node1;

        deleteSingleNodes(head,3);

        while (head!=null){
            System.out.println(head.value);
            head = head.next;
        }
    }
}
