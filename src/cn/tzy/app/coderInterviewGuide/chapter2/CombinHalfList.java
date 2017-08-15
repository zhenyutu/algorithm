package cn.tzy.app.coderInterviewGuide.chapter2;

/**
 * Created by tuzhenyu on 17-8-15.
 * @author tuzhenyu
 */
public class CombinHalfList {
    public static Node combin(Node head){
        if (head==null||head.next==null){
            return head;
        }
        Node mid = head;
        Node cur = head.next;
        while (cur.next!=null&&cur.next.next!=null){
            cur = cur.next.next;
            mid = mid.next;
        }
        cur = mid.next;
        mid.next = null;
        return merge(head,cur);
    }
    private static Node merge(Node left,Node right){
        Node head = left;
        Node next = null;
        while (left.next!=null){
            next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = next;
        }
        left.next = right;
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

        head = combin(head);

        while (head!=null){
            System.out.println(head.value);
            head = head.next;
        }
    }
}
