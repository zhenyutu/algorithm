package cn.tzy.app.coderInterviewGuide.chapter2;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-8-1.
 * @author tuzhenyu
 */
public class Palindromal {
    public static boolean isPalindromal(Node head){
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        while (head.next!=null&&!stack.isEmpty()){
            Node node = stack.pop();
            Node node1 = head;
            if (node.value!=node1.value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node head = node1;

        System.out.println(isPalindromal(head));
    }
}
