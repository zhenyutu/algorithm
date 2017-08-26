package cn.tzy.app.leetcode.linkedList;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-8-26.
 * @author tuzhenyu
 * leetcode_234
 */
public class PalindromeLinkedList {
    /**
     * 空间复杂度O(n) 时间复杂度O(n)
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        while (cur!=null){
            ListNode tmp = stack.pop();
            if (tmp.val!=cur.val){
                return false;
            }
            cur = cur.next;
        }

        return true;
    }
}
