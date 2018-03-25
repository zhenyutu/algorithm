package cn.tzy.app.xiaozhao2018.leetcode;

/**
 * Created by tuzhenyu on 18-3-25.
 * @author tuzhenyu
 */
public class InsertSortList {
    public ListNode insertSort(ListNode head){
        if (head==null||head.next==null)
            return head;
        ListNode cur = head;
        ListNode next = head.next;
        ListNode sortedList = new ListNode(Integer.MIN_VALUE);
        while (cur!=null){
            next = cur.next;
            ListNode sortedCur = sortedList;
            while (sortedCur.next!=null&&sortedCur.next.val<cur.val){
                sortedCur = sortedCur.next;
            }
            ListNode sortedNext = sortedCur.next;
            sortedCur.next = cur;
            cur.next = sortedNext;
            cur = next;
        }

        return sortedList.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);

        node1.next = node2;

        InsertSortList list = new InsertSortList();
        ListNode node = list.insertSort(node1);

        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
