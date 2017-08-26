package cn.tzy.app.leetcode.linkedList;

/**
 * Created by tuzhenyu on 17-8-26.
 * @author tuzhenyu
 * leetcode_21
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null||l2==null){
            return l1==null?l2:l1;
        }

        ListNode head = l1.val<l2.val?l1:l2;
        ListNode cur1 = head==l1?l1:l2;
        ListNode cur2 = head==l1?l2:l1;
        ListNode next,pre = null;
        while (cur1!=null&&cur2!=null){
            if (cur1.val<=cur2.val){
                pre =cur1;
                cur1 = cur1.next;
            }else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }

        if (cur1==null){
            pre.next = cur2;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(3);
//        ListNode node3 = new ListNode(5);

        ListNode node4 = new ListNode(1);


//        node1.next = node2;
//        node2.next = node3;
//        node4.next = node5;
//        node5.next = node6;

        ListNode head1 = node1;
        ListNode head2 = node4;

        MergeTwoSortedLists m = new MergeTwoSortedLists();
        ListNode head = m.mergeTwoLists(head1,head2);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
