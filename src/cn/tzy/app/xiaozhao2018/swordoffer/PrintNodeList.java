package cn.tzy.app.xiaozhao2018.swordoffer;

/**
 * Created by tuzhenyu on 18-3-15.
 * @author tuzhenyu
 */
public class PrintNodeList {
    public void print(ListNode head){
        if (head==null)
            return;
        else
            print(head.next);
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        PrintNodeList p = new PrintNodeList();
        p.print(node1);
    }
}
