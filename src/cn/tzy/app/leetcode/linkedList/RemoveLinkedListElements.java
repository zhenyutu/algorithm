package cn.tzy.app.leetcode.linkedList;

import cn.tzy.app.dataStructure.chapter3.List;

/**
 * Created by tuzhenyu on 17-8-26.
 * @author tuzhenyu
 * leetcode_203
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeNode = new ListNode(-1);
        fakeNode.next=head;
        ListNode cur = head;
        ListNode pre = fakeNode;
        while (cur!=null){
            if (cur.val==val){
                cur = cur.next;
                pre.next = cur;
            }else {
                cur = cur.next;
                pre = pre.next;
            }
        }

        return fakeNode.next;
    }
}
