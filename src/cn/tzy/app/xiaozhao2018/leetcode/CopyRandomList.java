package cn.tzy.app.xiaozhao2018.leetcode;

/**
 * Created by tuzhenyu on 18-3-28.
 * @author tuzhenyu
 */

 class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 }


public class CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head==null||head.next==null)
            return head;
        RandomListNode cur = head;
        RandomListNode next = head.next;
        while (cur!=null){
            next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }

        cur = head;
        while (cur!=null){
            cur.next.random = cur.random;
            cur = cur.next.next;
        }

        RandomListNode res = head.next;
        cur = head.next;
        next = head.next.next;
        while (cur.next!=null){
            cur.next = cur.next.next;
            cur = cur.next;
        }

        return res;
    }
}
