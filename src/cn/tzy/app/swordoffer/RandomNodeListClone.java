package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-5.
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
    public RandomListNode Clone(RandomListNode pHead)
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
