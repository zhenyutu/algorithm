package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-10.
 * @author tuzhenyu
 */
public class KthNodeToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head==null)
            return null;

        ListNode pre = head;
        ListNode cur = head;

        int len = 0;
        while (head!=null){
            head = head.next;
            len++;
        }
        if (k>len)
            return null;

        for (int i=0;i<k;i++){
            pre = pre.next;
        }
        while (pre!=null){
            pre = pre.next;
            cur = cur.next;
        }

        return cur;
    }

    public ListNode FindKthToTail2(ListNode head,int k) {
        ListNode fast = head;
        ListNode slow = head;
        int len = 0;
        while (head!=null){
            len++;
            head = head.next;
        }
        if (k>len||k<=0)
            return null;
        while (--k>0){
            fast = fast.next;
        }
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
