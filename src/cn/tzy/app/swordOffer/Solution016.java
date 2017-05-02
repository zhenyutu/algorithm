package cn.tzy.app.swordOffer;

/**
 * Created by tuzhenyu on 17-5-2.
 * @author tuzhenyu
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution016 {
    /**
     *单向链表查找倒数第k个元素,维护两个指针。先将前指针移动k个，然后一起移动两个指针直至前指针到达尾部
     */
    public static ListNode FindKthToTail(ListNode head,int k) {
        if (head==null||k<1)
            return null;
        ListNode before = head;
        ListNode after = head;
        for (int i=1;i<k;i++){
            if (before.next==null)
                return null;
            before = before.next;
        }
        while (before.next!=null){
            before = before.next;
            after = after.next;
        }
        return after;
    }

    /**
     *使用递归的思路行不通
     */
    private static ListNode getNode(ListNode node,int k){
        ListNode node1 = null;
        if (node.next!=null){
            getNode(node.next,k);
            k--;
            if (k<1)
                return node;
        }else{
            k--;
            if (k<1)
                return node;
        }
        return node1;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
//        ListNode node = null;
        System.out.println(FindKthToTail(node,1).val);
    }
}
