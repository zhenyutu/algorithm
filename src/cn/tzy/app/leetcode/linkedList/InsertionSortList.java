package cn.tzy.app.leetcode.linkedList;

import cn.tzy.app.dataStructure.chapter3.List;

/**
 * Created by tuzhenyu on 17-8-28.
 * @author tuzhenyu
 * leetcode_147
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head==null||head.next==null)
            return head;
        ListNode fake = new ListNode(-1);
        fake.next =head;
        ListNode cur = head.next;
        head.next = null;
        ListNode pre,next,tmp=fake;

        while (cur!=null){
            next = cur.next;
            pre = fake.next;
            while (pre!=null){
                if (pre.val>cur.val){
                    tmp.next = cur;
                    cur.next = pre;
                    break;
                }
                tmp = pre;
                pre = pre.next;
            }
            tmp.next = cur;
            cur.next = pre;

            cur = next;
        }


        return fake.next;
    }

    public ListNode insertionSortList2(ListNode head) {
        if (head==null||head.next==null)
            return head;
        ListNode fake = new ListNode(-1);
        ListNode pre = fake;
        ListNode cur = head;
        ListNode next;
        while (cur!=null){
            pre = fake;
            while (pre.next!=null&&pre.next.val<cur.val){
                pre = pre.next;
            }
            next = cur.next;
            cur.next  =pre.next;
            pre.next = cur;
            cur = next;
        }

        return fake.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(5);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = node1;

       InsertionSortList i = new InsertionSortList();
       head = i.insertionSortList2(head);

        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
