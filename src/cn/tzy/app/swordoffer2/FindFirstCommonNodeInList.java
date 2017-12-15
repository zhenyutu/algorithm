package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-15.
 * @author tuzhenyu
 */
public class FindFirstCommonNodeInList {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null||pHead2==null)
            return null;
        int len1=0,len2=0;
        ListNode cur1 = pHead1 ,cur2 = pHead2;
        while (cur1!=null){
            cur1=cur1.next;
            len1++;
        }
        while (cur2!=null){
            cur2=cur2.next;
            len2++;
        }

        cur1 = len1>=len2?pHead1:pHead2;
        cur2 = cur1==pHead1?pHead2:pHead1;
        int count = Math.abs(len1-len2);
        while (count>0){
            cur1 = cur1.next;
            count--;
        }

        while (cur1!=null&&cur2!=null){
            if (cur1==cur2)
                return cur1;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return null;
    }

    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
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
}
