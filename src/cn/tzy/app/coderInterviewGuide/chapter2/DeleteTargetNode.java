package cn.tzy.app.coderInterviewGuide.chapter2;

/**
 * Created by tuzhenyu on 17-8-11.
 * @author tuzhenyu
 */
public class DeleteTargetNode {
    public static Node delete(Node head,int num){
        Node cur = head;
        Node next = null;
        Node pre = null;
        while (cur!=null){
            next = cur.next;
            if (cur.value==num){
                if (pre==null){
                    head=head.next;
                }else {
                    pre.next = next;
                }
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(3);
        Node node5 = new Node(3);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        Node head = node1;

        head = delete(head,3);

        while (head!=null){
            System.out.println(head.value);
            head = head.next;
        }
    }
}
