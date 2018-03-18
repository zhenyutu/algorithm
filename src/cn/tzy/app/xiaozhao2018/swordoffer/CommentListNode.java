package cn.tzy.app.xiaozhao2018.swordoffer;

/**
 * Created by tuzhenyu on 18-3-17.
 * @author tuzhenyu
 */
public class CommentListNode {
    public ListNode getCommentNode(ListNode node1,ListNode node2){
        if (node1==null||node2==null)
            return null;
        int len1 = 0,len2 = 0;
        ListNode cur1 = node1,cur2 = node2;
        while (cur1!=null){
            cur1 = cur1.next;
            len1++;
        }
        while (cur2!=null){
            cur2 = cur2.next;
            len2++;
        }

        cur1 = len1>len2?node1:node2;
        cur2 = cur1==node1?node2:node1;

        for (int i=0;i<Math.abs(len1-len2);i++){
            cur1 = cur1.next;
        }

        while (cur1!=null&&cur2!=null){
            if (cur1==cur2)
                return cur1;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return null;
    }
}
