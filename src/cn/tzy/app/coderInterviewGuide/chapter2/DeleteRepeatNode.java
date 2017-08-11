package cn.tzy.app.coderInterviewGuide.chapter2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tuzhenyu on 17-8-11.
 * @author tuzhenyu
 */
public class DeleteRepeatNode {
    /**
     * 利用额外空间哈希表删除重复节点
     * 时间复杂度O(n),空间复杂度O(n)
     * @param head
     */
    private static void delete(Node head){
        Node cur = head;
        Node pre = null;
        Node next = null;
        Set<Integer> set = new HashSet<>();

        while (cur!=null){
            next = cur.next;
            if (set.contains(cur.value)){
                pre.next = next;
            }
            set.add(cur.value);
            pre = cur;
            cur = next;
        }
    }
    private static void delete2(Node head){
        Node cur = head;
        Node next = null;
        Node tmp = null;

        Node innerPre = null;
        Node innerNext = null;
        while (cur!=null){
            next = cur.next;
            tmp = next;
            while (tmp!=null){
                innerNext = tmp.next;
                if (tmp.value==cur.value){
                    innerPre.next = innerNext;
                }
                innerPre = tmp;
                tmp = innerNext;
            }
            cur = next;
        }
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(1);
        Node node4 = new Node(4);
        Node node5 = new Node(1);
        Node node6 = new Node(6);
        Node node7 = new Node(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        Node head = node1;

        delete2(head);

        while (head!=null){
            System.out.println(head.value);
            head = head.next;
        }
    }
}
