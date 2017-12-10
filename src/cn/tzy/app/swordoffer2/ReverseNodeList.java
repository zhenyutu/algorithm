package cn.tzy.app.swordoffer2;

import java.util.LinkedList;

/**
 * Created by tuzhenyu on 17-12-10.
 * @author tuzhenyu
 */
public class ReverseNodeList {
    public ListNode ReverseList(ListNode head) {
        if (head==null)
            return null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public ListNode ReverseList2(ListNode head) {
        ListNode current = head;
        LinkedList<ListNode> list = new LinkedList<>();
        if (head == null)
            return null;
        while (current!=null){
            list.push(current);
            current = current.next;
        }
        ListNode head2 = list.pop();
        head2.next = null;
        ListNode current2 = head2;
        while (!list.isEmpty()){
            ListNode node = list.pop();
            node.next = null;
            current2.next = node;
            current2 = current2.next;
        }

        return head2;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ReverseNodeList r = new ReverseNodeList();
        ListNode l = r.ReverseList(node);
        while (l!=null){
            System.out.print(l.val+" ");
            l = l.next;
        }
    }
}
