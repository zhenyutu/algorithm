package cn.tzy.app.leetcode.linkedList;

/**
 * Created by tuzhenyu on 17-8-27.
 * @author tuzhenyu
 * leetcode_61
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null)
            return head;

        ListNode cur = head;
        int len = 0;
        while (cur!=null){
            len++;
            cur = cur.next;
        }

        ListNode pre = head;
        ListNode post = head;
        while (k%len>0){
            pre  =pre.next;
            k--;
        }
        while (pre.next!=null){
            post = post.next;
            pre = pre.next;
        }
        pre.next = head;
        head = post.next;
        post.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = node1;

        RotateList r = new RotateList();
        head = r.rotateRight(head,6);

        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
