package cn.tzy.app.swordOffer;

/**
 * Created by tuzhenyu on 17-5-5.
 * @author tuzhenyu
 */
public class Solution018 {
    /**
     *构建第三个链表，简化链表操作
     * 遍历两个链表，比较发小将较小的引向结果链表
     * 43ms 654k
     */
    public static ListNode Merge(ListNode list1,ListNode list2) {
        ListNode node = new ListNode(0);
        ListNode header = node;
        while (list1!=null&&list2!=null){
            if (list1.val<list2.val){
                node.next = list1;
                node = node.next;
                list1 = list1.next;
            }else{
                node.next = list2;
                node = node.next;
                list2 = list2.next;
            }
        }
        if (list1!=null)
            node.next = list1;
        if (list2!=null)
            node.next = list2;

        return header.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(3);
        node2.next.next.next = new ListNode(4);

        ListNode head = Merge(node,node2);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
