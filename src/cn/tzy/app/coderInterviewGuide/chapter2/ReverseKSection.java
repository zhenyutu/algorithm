package cn.tzy.app.coderInterviewGuide.chapter2;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-8-10.
 * @author tuzhenyu
 */
public class ReverseKSection {
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
