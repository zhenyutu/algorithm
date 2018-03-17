package cn.tzy.app.xiaozhao2018.swordoffer;

/**
 * Created by tuzhenyu on 18-3-16.
 * @author tuzhenyu
 */
public class FindKthToTail {
    public ListNode find(ListNode head,int k){
        ListNode fast = head;
        ListNode slow = head;
        for (int i=0;i<k;i++){
            fast = fast.next;
        }

        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
