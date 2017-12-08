package cn.tzy.app.swordoffer2;


import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by tuzhenyu on 17-12-8.
 * @author tuzhenyu
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class PrintNodeListReverse {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode==null)
            return arrayList;
        Stack<Integer> stack = new Stack<>();
        stack.push(listNode.val);
        while (listNode.next!=null){
            listNode = listNode.next;
            stack.push(listNode.val);
        }
        while (!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }
}
