package cn.tzy.app.leetcode.linkedList;


/**
 * Created by tuzhenyu on 17-8-27.
 * @author tuzhenyu
 * leetcode_148
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode node = sortList(slow.next);
        slow.next = null;
        return merge(sortList(head),node);
    }

    private ListNode merge(ListNode head1, ListNode head2){
        ListNode fake = new ListNode(-1);
        ListNode pre = fake;
        while (head1!=null&&head2!=null){
            if (head1.val<head2.val){
                pre.next = head1;
                head1 = head1.next;
            }else {
                pre.next = head2;
                head2 = head2.next;
            }
            pre = pre.next;
        }
        if (head1==null){
            pre.next = head2;
        }else {
            pre.next = head1;
        }

        return fake.next;
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

        SortList s = new SortList();
        head = s.sortList(head);

        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
