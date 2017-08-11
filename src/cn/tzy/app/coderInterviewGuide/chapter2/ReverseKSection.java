package cn.tzy.app.coderInterviewGuide.chapter2;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-8-10.
 * @author tuzhenyu
 */
public class ReverseKSection {
    /**
     * 利用栈辅助空间对链表进行部分翻转
     * 时间复杂度为O(n),空间复杂度为O(n)
     * @param head
     * @param k
     * @return
     */
    public static Node reverse(Node head,int k){
        if (head==null||k<2)
            return null;
        Stack<Node> stack = new Stack<>();
        Node newHead = head;
        Node cur = head;
        Node next=null;
        Node pre = null;
        while (cur!=null){
            next = cur.next;
            stack.push(cur);
            if (stack.size()==k){
                pre = solve(stack,pre,next);
                newHead = newHead==head?cur:newHead;
            }
            cur = next;
        }

        return newHead;
    }
    private static Node solve(Stack<Node>stack,Node left,Node right){
        Node cur = stack.pop();
        if (left!=null)
            left.next = cur;
        Node next = null;
        while (!stack.isEmpty()){
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
    }

    /**
     * 直接在链表上进行变换，不适用额外的空间
     * 时间复杂度为O(n),空间复杂度为O(1)
     * @param head
     * @param k
     * @return
     */
    public static Node reverse2(Node head,int k){
        if (head==null||k<2)
            return null;
        Node cur = head;
        Node next=null;
        Node pre = null;
        Node start = null;
        int count = 0;
        while (cur!=null){
            next = cur.next;
            if (count==k){
                count = 0;
                start = pre==null?head:pre.next;
                head = pre==null?cur:head;
                solve2(pre,start,cur,next);
                pre = start;
            }
            cur = next;
            count++;
        }

        return head;
    }
    private static void solve2(Node left,Node start,Node end,Node right){
        Node pre = start;
        Node cur = start.next;
        Node next = null;
        while (cur!=right){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (left!=null){
            left.next = end;
        }
        start.next = right;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        Node head = node1;

        head = reverse(head,3);

        while (head!=null){
            System.out.println(head.value);
            head = head.next;
        }
    }
}
