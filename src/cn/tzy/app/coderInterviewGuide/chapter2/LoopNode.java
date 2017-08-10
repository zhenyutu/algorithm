package cn.tzy.app.coderInterviewGuide.chapter2;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;
import jdk.nashorn.internal.objects.NativeUint8Array;

/**
 * Created by tuzhenyu on 17-8-10.
 * @author tuzhenyu
 */
public class LoopNode {
    private static boolean hasLoop(Node head){
        Node fast = head;
        Node slow = head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow)
                return true;
        }
        return false;
    }

    private static Node getLoopNode(Node head){
        Node fast = head;
        Node slow = head;
        Node node = null;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow){
                fast = head;
                while (fast!=slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return node;
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node2;
        Node head = node1;

        System.out.println(hasLoop(head));
        System.out.println(getLoopNode(head).value);

    }
}
