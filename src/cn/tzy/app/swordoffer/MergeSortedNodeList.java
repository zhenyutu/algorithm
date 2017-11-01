package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-1.
 * @author tuzhenyu
 */
public class MergeSortedNodeList {
    public ListNode Merge(ListNode list1,ListNode list2) {
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

    }
}
