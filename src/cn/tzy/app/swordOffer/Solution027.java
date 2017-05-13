package cn.tzy.app.swordOffer;

/**
 * Created by tuzhenyu on 17-5-13.
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
public class Solution027 {
    /**
     *复杂链表的复制,最容易想到的是分两步先将链表顺序复制成一个新的链表，再将两个链表一起循环遍历完善Random指针
     */
    public static RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead==null)
            return null;
        RandomListNode pCurrent = pHead;
        RandomListNode head = new RandomListNode(pHead.label);
        RandomListNode current = head;
        while (pCurrent.next!=null){
            current.next = new RandomListNode(pCurrent.next.label);
            current = current.next;
            pCurrent = pCurrent.next;
        }
        current.next = null;
        current = head;
        pCurrent = pHead;
        while (current!=null&&pCurrent!=null){
            RandomListNode pTail = pHead;
            if (pCurrent.random!=null){
                while (pTail!=null){
                    if (pTail==pCurrent.random){
                        current.random = pTail;
                        break;
                    }
                    pTail = pTail.next;
                }
            }
            current = current.next;
            pCurrent = pCurrent.next;
        }
        return head;
    }

    public static void main(String[] args) {
        RandomListNode node = new RandomListNode(1);
        node.next = new RandomListNode(2);
        node.next.next = new RandomListNode(3);

        RandomListNode head  = Clone(node);
        while (head!=null){
            System.out.println(head.label);
            head = head.next;
        }
    }
}
