package cn.tzy.app.leetcode.linkedList;

/**
 * Created by tuzhenyu on 17-8-26.
 * @author tuzhenyu
 * leetcode_83
 */
public class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null)
            return head;

        ListNode pre = head;
        ListNode post = head.next;
        while (post!=null){
            if (pre.val == post.val){
                pre.next = post.next;
                post = pre.next;
            }else {
                pre = pre.next;
                post = post.next;
            }
        }

        return head;
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

        RemoveDuplicates r = new RemoveDuplicates();
        head = r.deleteDuplicates(head);

        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
