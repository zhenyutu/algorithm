package cn.tzy.app.leetcode;

/**
 * Created by tuzhenyu on 17-4-8.
 * @author tuzhenyu
 */
public class Leetcode_002 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;

        while (l1!=null||l2!=null){
            int sum = l1.val+l2.val;
            if (sum>9)
                result = new ListNode(sum%10);
            else
                result = new ListNode(sum);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
