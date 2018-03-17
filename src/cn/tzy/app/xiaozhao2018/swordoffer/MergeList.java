package cn.tzy.app.xiaozhao2018.swordoffer;

/**
 * Created by tuzhenyu on 18-3-16.
 * @author tuzhenyu
 */
public class MergeList {
    public ListNode merge(ListNode head1,ListNode head2){
        if (head1==null||head2==null){
            return head1==null?head1:head2;
        }

        ListNode list1 = head1.val<head2.val?head1:head2;
        ListNode list2 = list1==head1?head2:head1;

        ListNode cur1 = list1;
        ListNode cur2 = list2;

        ListNode next1,next2;

        while (cur1.next!=null&&cur2.next!=null){
            if (cur1.val<=cur2.val){
                next1 = cur1.next;
                next2 = cur2.next;
                cur1.next = cur2;
                cur2.next = next1;
                cur2 = next2;
            }else {
                cur1 = cur1.next;
            }
        }

        if (cur1.next==null){
            cur1.next = cur2;
        }

        return list1;
    }
}
