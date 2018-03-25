package cn.tzy.app.xiaozhao2018.leetcode;


/**
 * Created by tuzhenyu on 18-3-25.
 * @author tuzhenyu
 */
public class SortLinkedList {
    public ListNode sortList(ListNode head){
        if (head==null||head.next==null)
            return head;
        ListNode mid = getMid(head);
        ListNode next = mid.next;
        mid.next = null;

        return merge(sortList(head),sortList(next));
    }

    private ListNode getMid(ListNode node){
        ListNode fast = node;
        ListNode slow = node;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode merge(ListNode list1,ListNode list2){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while (cur1!=null&&cur2!=null){
            if (cur1.val<cur2.val){
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            }else {
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
        }

        cur.next = cur1==null?cur2:cur1;

        return head.next;
    }
}
