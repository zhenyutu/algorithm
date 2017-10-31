package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-10-31.
 * @author tuzhenyu
 */
public class ListNodeKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
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
