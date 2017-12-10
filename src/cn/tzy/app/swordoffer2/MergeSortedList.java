package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-10.
 * @author tuzhenyu
 */
public class MergeSortedList {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null||list2==null)
            return list1==null?list2:list1;
        ListNode cur1 = list1.val<list2.val?list1:list2;
        ListNode cur2 = cur1==list1?list2:list1;
        ListNode pre1 = cur1;
        ListNode pre2 = cur2;
        while (cur1!=null&&cur2!=null){
            if (cur1.val<=cur2.val){
                pre1 = cur1;
                cur1 = cur1.next;
            }else {
                pre2 = cur2.next;
                pre1.next = cur2;
                cur2.next = cur1;
                cur2 = pre2;
            }
        }
        if (cur1==null)
            pre1.next = cur2;

        return list1.val<list2.val?list1:list2;
    }

    public ListNode Merge2(ListNode list1,ListNode list2) {
        if (list1==null||list2==null)
            return list1==null?list2:list1;
        ListNode head1 = list1.val<list2.val?list1:list2;
        ListNode head2 = head1==list1?list2:list1;
        ListNode pre1 = null;
        ListNode pre2 = null;
        ListNode res = head1;
        while (head1!=null&&head2!=null){
            if (head1.val<=head2.val){
                pre1 = head1;
                head1 = head1.next;
            }else {
                pre2 = head2;
                head2 = head2.next;
                pre1.next = pre2;
                pre2.next = head1;
            }
        }
        if (head2!=null)
            pre1.next = head2;

        return res;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        ListNode node8 = new ListNode(8);

        node.next = node2;
        node2.next = node4;
        node4.next = node6;
        node6.next = node8;
        node8.next = null;

        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node7 = new ListNode(7);
        ListNode node9 = new ListNode(9);

        node1.next = node3;
        node3.next = node5;
        node5.next = node7;
        node7.next = node9;
        node9.next = null;

        MergeSortedList m = new MergeSortedList();
        ListNode l = m.Merge(node,node1);
        while (l!=null){
            System.out.print(l.val+" ");
            l = l.next;
        }
    }
}
