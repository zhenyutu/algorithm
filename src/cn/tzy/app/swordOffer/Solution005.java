package cn.tzy.app.swordOffer;


import java.util.*;

/**
 * Created by tuzhenyu on 17-4-27.
 * @author tuzhenyu
 */
public class Solution005 {
    static class ListNode {
       int val;
       ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     *利用栈的思想 将链表倒序输出
     * 36ms 654k
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Deque<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (listNode!=null){
            queue.push(listNode.val);
            listNode = listNode.next;
        }
        while (!queue.isEmpty()){
            arrayList.add(queue.poll());
        }
        return arrayList;
    }

    /**
     *利用递归思想 如果下一节点不为空则先添加下一节点
     * 34ms 629k
     */

    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode!=null)
            addToList(arrayList,listNode);
        return arrayList;
    }

    public static void addToList(List list , ListNode node){
        if (node.next!=null){
            addToList(list,node.next);
            list.add(node.val);
        }else{
            list.add(node.val);
        }

    }

    public static void main(String[] args) {
//        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
        ListNode node = null;
        System.out.println(printListFromTailToHead2(node).toString());
    }
}
