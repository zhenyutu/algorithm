package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-19.
 * @author tuzhenyu
 */
public class FirstCommentNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null||pHead2==null)
            return null;
        int count1 = 0;
        int count2 = 0;
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while (node1!=null){
            count1++;
            node1 = node1.next;
        }
        while (node2!=null){
            count2++;
            node2 = node2.next;
        }
        int count = 0;
        if (count1>count2){
            node1 = pHead1;
            node2 = pHead2;
            count = count1 - count2;
        }else {
            node1 = pHead2;
            node2 = pHead1;
            count = count2 - count1;
        }
        while (count>0){
            node1 = node1.next;
            count--;
        }
        while (node1!=null&&node2!=null){
            if (node1==node2)
                return node1;
            node1 = node1.next;
            node2 = node2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node4;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        FirstCommentNode f = new FirstCommentNode();
        System.out.println(f.FindFirstCommonNode(node1,node2).val);
    }
}
