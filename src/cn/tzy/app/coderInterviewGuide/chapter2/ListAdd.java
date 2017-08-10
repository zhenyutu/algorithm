package cn.tzy.app.coderInterviewGuide.chapter2;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-8-10.
 * @author tuzhenyu
 */
public class ListAdd {
    public static Node add(Node head1,Node head2){
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        Node cur;
        cur = head1;
        while (cur!=null){
            stack1.push(cur.value);
            cur = cur.next;
        }
        cur = head2;
        while (cur!=null){
            stack2.push(cur.value);
            cur = cur.next;
        }

        int ca = 0;
        int tmp = 0;
        int tmp1 = 0;
        int tmp2 = 0;
        Node node = null;
        Node pre = null;
        while (!stack1.isEmpty()||!stack2.isEmpty()){
            tmp1 = stack1.isEmpty()?0:stack1.pop();
            tmp2 = stack2.isEmpty()?0:stack2.pop();
            tmp = tmp1+tmp2+ca;
            pre = node;
            node = new Node(tmp%10);
            ca = tmp/10;
            node.next = pre;
        }
        if (ca==1){
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        return node;
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(9);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;
        Node head1 = node1;
        Node head2 = node4;

        Node head = add(head1,head2);

        while (head!=null){
            System.out.println(head.value);
            head = head.next;
        }
    }
}
