package cn.tzy.app.coderInterviewGuide.chapter2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuzhenyu on 17-8-4.
 * @author tuzhenyu
 */
class Node2{
    public int value;
    public Node2 next;
    public Node2 random;

    public Node2(int value){
        this.value = value;
    }
}

public class CopyRandomList {
    public static Node2 copy(Node2 head){
        if (head==null)
            return null;
        Node2 cur = head;
        Map<Node2,Node2> map = new HashMap<>();
        while (cur!=null){
            Node2 node = new Node2(cur.value);
            map.put(cur,node);
            cur = cur.next;
        }
        cur = head;
        while (cur!=null){
            Node2 next = cur.next;
            Node2 random = cur.random;
            Node2 tmp = map.get(cur);
            tmp.next = map.get(next);
            tmp.random = map.get(random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node2 copy2(Node2 head){
        if (head==null)
            return head;
        Node2 cur = head;
        Node2 tmp;
        while (cur!=null){
            Node2 c = new Node2(cur.value);
            tmp= cur.next;
            cur.next = c;
            c.next = tmp;
            cur = cur.next;
        }
        cur = head;
        Node2 copyNode = null;
        while (cur!=null){
            copyNode = cur.next;
            copyNode.random = cur.random!=null?cur.random.next:null;
            cur = cur.next.next;
        }
        Node2 res = head.next;
        cur = head;
        while (cur!=null){
            tmp = cur.next.next;
            copyNode = cur.next;
            copyNode.next = tmp!=null?tmp.next:null;
            cur = tmp;

        }
        return head;
    }

    public static void main(String[] args) {
        Node2 node1 = new Node2(1);
        Node2 node2 = new Node2(2);
        Node2 node3 = new Node2(3);
        Node2 node4 = new Node2(4);
        Node2 node5 = new Node2(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node2 head = node1;

        copy(head);

        while (head!=null){
            System.out.println(head.value);
            head = head.next;
        }
    }
}
