package cn.tzy.app.xiaozhao2017.swordoffer;

import cn.tzy.app.dataStructure.chapter3.List;

/**
 * Created by tuzhenyu on 18-3-16.
 * @author tuzhenyu
 */
public class FindKthToTail {
    public ListNode find(ListNode head,int k){
        ListNode fast = head;
        ListNode slow = head;
        for (int i=0;i<k;i++){
            fast = fast.next;
        }

        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
