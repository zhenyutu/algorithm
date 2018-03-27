package cn.tzy.app.xiaozhao2018.leetcode;

import cn.tzy.app.dataStructure.chapter3.List;

import java.util.Stack;

/**
 * Created by tuzhenyu on 18-3-25.
 * @author tuzhenyu
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head==null||head.next==null)
            return;

        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        Stack<ListNode> stack = new Stack<>();
        while (mid!=null){
            stack.push(mid);
            mid = mid.next;
        }

        ListNode cur = head;
        ListNode next = head.next;
        while (!stack.isEmpty()){
            next = cur.next;
            cur.next = stack.pop();
            cur.next.next = next;
            cur = next;
        }
    }
}
