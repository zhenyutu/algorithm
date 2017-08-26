package cn.tzy.app.leetcode.linkedList;

/**
 * Created by tuzhenyu on 17-8-26.
 * @author tuzhenyu
 * leetcode_160
 */
public class IntersectionTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int ALen=0;
        int BLen = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA!=null){
            ALen++;
            nodeA = nodeA.next;
        }
        while (nodeB!=null){
            BLen++;
            nodeB = nodeB.next;
        }
        if (ALen>BLen){
            while (ALen>BLen){
                headA = headA.next;
                ALen--;
            }
        }else {
            while (ALen<BLen){
                headB = headB.next;
                BLen--;
            }
        }

        while (headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
