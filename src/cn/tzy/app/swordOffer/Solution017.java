package cn.tzy.app.swordOffer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tuzhenyu on 17-5-4.
 * @author tuzhenyu
 */
public class Solution017 {
    /**
     *利用栈作为中间存储实现链表的翻转
     * 33ms 629k
     */
    public static ListNode ReverseList(ListNode head) {
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

    /**
     *原地链表翻转不改变位置，只改变节点的next指针指向
     *
     */
    public static ListNode ReverseList2(ListNode head) {
       if(head == null){
           return null;
       }
       ListNode pre = null;
       ListNode next;
       while (head!=null){
           next = head.next;
           head.next = pre;
           pre = head;
           head = next;
       }
       return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);

        ListNode head = ReverseList2(node);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
