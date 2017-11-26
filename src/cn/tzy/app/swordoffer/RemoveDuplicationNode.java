package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-26.
 */
public class RemoveDuplicationNode {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead==null)
            return null;
        ListNode first = new ListNode(-1);
        first.next = pHead;
        ListNode pre = first;
        ListNode cur = pHead;
        while (cur!=null&&cur.next!=null){
            if (cur.val == cur.next.val){
                while (cur.next!=null&&cur.val == cur.next.val){
                    cur.next = cur.next.next;
                }
                pre.next = cur.next;
                cur = pre.next;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return first.next;
    }
}
