package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-19.
 * @author tuzhenyu
 */
public class GetEntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if (pHead==null)
            return null;
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;

        while (fast!=slow){
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = pHead;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
