package cn.tzy.app.leetcode.linkedList;

/**
 * Created by tuzhenyu on 17-8-25.
 * @author tuzhenyu
 * leetcode_141
 */

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
      val = x;
      next = null;
  }
}


public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode pre = head;
        ListNode post = head;

        while (pre!=null&&pre.next!=null){
            pre = pre.next.next;
            post = post.next;
            if (pre == post)
                return true;
        }
        return false;
    }
}
