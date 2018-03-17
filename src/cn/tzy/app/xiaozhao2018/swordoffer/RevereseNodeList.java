package cn.tzy.app.xiaozhao2018.swordoffer;

/**
 * Created by tuzhenyu on 18-3-16.
 * @author tuzhenyu
 */
public class RevereseNodeList {
    public ListNode reverse(ListNode head){
        if (head==null||head.next==null)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;

        while (cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
