package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-12.
 * @author tuzhenyu
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class RandomNodeListClone {
    public RandomListNode Clone(RandomListNode pHead){
        if (pHead==null)
            return null;
        RandomListNode cur = pHead;
        RandomListNode next;
        while (cur!=null){
            next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }
        cur = pHead;
        while (cur!=null){
            if (cur.random!=null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        cur = pHead;
        RandomListNode head = pHead.next;
        RandomListNode node = head;
        while (cur!=null){
            cur.next = cur.next.next;
            if (cur.next!=null)
                node.next = cur.next.next;
            node = node.next;
            cur = cur.next;
        }

        return head;
    }

    public RandomListNode Clone2(RandomListNode pHead)
    {
        if (pHead==null)
            return null;
        RandomListNode pCur = pHead;
        while (pCur!=null){
            RandomListNode node = new RandomListNode(pCur.label);
            RandomListNode tmp = pCur.next;
            pCur.next = node;
            node.next = tmp;
            pCur = pCur.next.next;
        }
        pCur = pHead;
        while (pCur!=null){
            if (pCur.random!=null)
                pCur.next.random = pCur.random.next;
            pCur = pCur.next.next;
        }

        RandomListNode head = pHead.next;
        RandomListNode cur = head;
        pCur = pHead;
        while (pCur!=null){
            pCur.next = pCur.next.next;
            if (cur.next!=null)
                cur.next = cur.next.next;
            cur = cur.next;
            pCur = pCur.next;
        }

        return head;
    }
}

