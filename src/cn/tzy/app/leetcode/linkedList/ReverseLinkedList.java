package cn.tzy.app.leetcode.linkedList;


/**
 * Created by tuzhenyu on 17-8-26.
 * @author tuzhenyu
 * leetcode_206
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode post ;
        while (cur!=null){
            post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode head = node1;

        ReverseLinkedList r = new ReverseLinkedList();
        head = r.reverseList(head);

        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
