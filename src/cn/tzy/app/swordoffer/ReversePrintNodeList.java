package cn.tzy.app.swordoffer;

import cn.tzy.app.leetcode.Leetcode_002;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by tuzhenyu on 17-10-27.
 * @author tuzhenyu
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class ReversePrintNodeList {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.isEmpty()){
            res.add(stack.pop());
        }

        return res;
    }
}
