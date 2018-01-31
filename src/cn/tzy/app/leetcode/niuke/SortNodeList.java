package cn.tzy.app.leetcode.niuke;

import cn.tzy.app.dataStructure.chapter3.List;

/**
 * Created by tuzhenyu on 18-1-31.
 * @author tuzhenyu
 */
public class SortNodeList {
    public ListNode sortList(ListNode head) {
        if (head==null||head.next==null)
            return head;
        ListNode mid = getMid(head);
        ListNode next = mid.next;
        mid.next = null;
        return merge(sortList(head),sortList(next));
    }

    private ListNode getMid(ListNode head){
        if (head==null||head.next==null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode head1,ListNode head2){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while (cur1!=null&&cur2!=null){
            if (cur1.val<cur2.val){
                cur.next = cur1;
                cur1 = cur1.next;
            }else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        cur.next = cur1==null?cur2:cur1;
        return head.next;
    }
}
