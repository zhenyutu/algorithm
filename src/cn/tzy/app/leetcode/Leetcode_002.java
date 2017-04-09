package cn.tzy.app.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tuzhenyu on 17-4-8.
 * @author tuzhenyu
 */
public class Leetcode_002 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     *原始实现的addTwoNumbers
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode first = result;
        boolean over = false;

        while (l1!=null||l2!=null){
            if (l1==null&&l2!=null)
                l1 = new ListNode(0);
            else if (l1!=null&&l2==null)
                l2 = new ListNode(0);
            int sum = 0;
            if (over){
                sum = l1.val+l2.val+1;
                over = false;
            }
            else
                sum = l1.val+l2.val;
            ListNode oldResult = result;
            if (sum>9){
                result = new ListNode(sum%10);
                over = true;
            }
            else
                result = new ListNode(sum);
            result.next = null;
            oldResult.next=result;
            l1=l1.next;
            l2=l2.next;
        }
        if(over){
            result.next = new ListNode(1);
        }
        return first.next;
    }

    /**
     *改进后的addTwoNumbers
     */
    public ListNode addTwoNumbersCopy(ListNode l1, ListNode l2) {
        ListNode current = new ListNode(0);
        ListNode first = current;
        int carry = 0;

        while (l1!=null||l2!=null){
            int x = (l1!=null)?l1.val:0;
            int y = (l2!=null)?l2.val:0;
            int sum = x+y+carry;
            carry=sum/10;
            current.next = new ListNode(sum%10);
            current = current.next;
            if (l1!=null)
                l1=l1.next;
            if (l2!=null)
                l2=l2.next;
        }
        if(carry>0){
            current.next = new ListNode(1);
        }
        return first.next;
    }

    public ListNode getListNode(){
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        return l1;
    }

    public static void main(String[] args) {
        Leetcode_002 leetcode = new Leetcode_002();
        ListNode l1 = leetcode.getListNode();
        ListNode l2 = leetcode.getListNode();

        ListNode l = leetcode.addTwoNumbers(l1,l2);

        while (l!=null){
            System.out.println(l.val);
            l = l.next;
        }
    }
}
