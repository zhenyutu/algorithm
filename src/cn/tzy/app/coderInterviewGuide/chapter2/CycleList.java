package cn.tzy.app.coderInterviewGuide.chapter2;

/**
 * Created by tuzhenyu on 17-7-28.
 * @author tuzhenyu
 */
public class CycleList {
    public static Node josephusKill(Node head,int m){
        if (head==null||head.next==head|m<1)
            return head;
        Node last = head;
        while (last.next!=head){
            last = last.next;
        }

        int count=0;
        while (last!=head){
            if (++count==m){
                System.out.print(head.value+" ");
                last.next = head.next;
                count = 0;
            }else {
                last = last.next;
            }
            head = last.next;
        }

        return head;
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
        node5.next = node1;
        Node head = node1;

        josephusKill(head,3);
    }
}
