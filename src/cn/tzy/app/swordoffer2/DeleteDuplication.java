package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-19.
 * @author tuzhenyu
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead){
        if (pHead==null)
            return null;
        ListNode first = new ListNode(-1);
        first.next = pHead;
        ListNode pre = first;
        ListNode cur = pHead;

        while (cur!=null&&cur.next!=null){
            if (cur.next.val==cur.val){
                while (cur.next.val==cur.val){
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            }else {
                pre = cur;
                cur = cur.next;
            }
            
        }

        return first.next;
    }
}
