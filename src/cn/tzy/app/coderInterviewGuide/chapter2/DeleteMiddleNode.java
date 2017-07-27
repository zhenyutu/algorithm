package cn.tzy.app.coderInterviewGuide.chapter2;

/**
 * Created by tuzhenyu on 17-7-27.
 * @author tuzhenyu
 */
public class DeleteMiddleNode {
    public static Node deleteMidNode(Node head){
        if (head==null||head.next==null){
            return head;
        }
        if (head.next.next==null)
            head = head.next;
        Node pre = head;
        Node cur = head.next.next;

        while (cur.next!=null&&cur.next.next!=null){
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
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

        head = deleteMidNode(head);

        while (head!=null){
            System.out.println(head.value);
            head = head.next;
        }
    }
}
