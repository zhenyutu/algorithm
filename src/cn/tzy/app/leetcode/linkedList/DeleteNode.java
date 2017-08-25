package cn.tzy.app.leetcode.linkedList;

/**
 * Created by tuzhenyu on 17-8-25.
 * @author tuzhenyu
 * leetcode_237
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = node.next.next;
    }
}
