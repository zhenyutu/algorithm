package cn.tzy.app.xiaozhao2018.swordoffer;

/**
 * Created by tuzhenyu on 18-3-18.
 * @author tuzhenyu
 */
public class DeleteDuplicationNode {
    public ListNode deleteDuplication(ListNode head){
        if (head==null||head.next==null)
            return head;
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode pre = temp;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur!=null&&cur.next!=null){
            if (cur.val==next.val){
                while (cur.next!=null&&cur.val==next.val){
                    cur = cur.next;
                    next = next.next;
                }
                cur = cur.next;
                next = cur.next;
                pre.next = cur;
            }else {
                pre = pre.next;
                cur = cur.next;
                next = next.next;
            }
        }

        return temp;
    }
}
