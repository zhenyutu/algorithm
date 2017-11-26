package cn.tzy.app.swordoffer;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

/**
 * Created by tuzhenyu on 17-11-26.
 */
public class EntryNodeOfLoopList {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead==null)
            return null;
        ListNode slow = pHead.next;
        if (slow==null)
            return null;
        ListNode fast = pHead.next.next;
        while (fast!=slow){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pos = fast;
        fast = pHead;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
