package cn.tzy.app.coderInterviewGuide.chapter2;

/**
 * Created by tuzhenyu on 17-7-28.
 * @author tuzhenyu
 */
public class ReverseSectionList {
    public static Node reverse(Node head,int from,int to){
        int len = 0;
        Node node = head;
        Node pre = null;
        Node post = null;
        while (node.next!=null){
            len++;
            pre = len==from-1?node:pre;
            post = len==to?node:post;
            node = node.next;
        }

        if (from>to||from<1||to>len)
            return head;

        Node cur = pre.next;
        Node next = post.next;
        pre.next = post;
        Node node2 = post.next;
        Node tmp;
        while (cur!=next){
            tmp = cur.next;
            cur.next = node2;
            node2 = cur;
            cur = tmp;
        }

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

        head = reverse(head,2,4);

        while (head!=null){
            System.out.println(head.value);
            head = head.next;
        }
    }
}
