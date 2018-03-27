package cn.tzy.app.xiaozhao2018.leetcode;

/**
 * Created by tuzhenyu on 18-3-25.
 * @author tuzhenyu
 */
public class DetectCycleList {
    public ListNode detectCycle(ListNode head) {
        if (head==null||head.next==null)
            return null;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast!=null&&fast!=slow){
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast==null)
            return null;

        fast = head;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
