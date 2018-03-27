package cn.tzy.app.xiaozhao2018.leetcode;

/**
 * Created by tuzhenyu on 18-3-25.
 * @author tuzhenyu
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head==null||head.next==null)
            return false;
        ListNode fast = head.next;
        ListNode slow = head.next.next;
        while (fast!=null&&fast!=slow){
            fast = fast.next.next;
            slow = slow.next;
        }

        return !(fast==null);
    }
}
