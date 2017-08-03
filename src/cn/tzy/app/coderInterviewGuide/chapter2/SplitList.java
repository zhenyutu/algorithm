package cn.tzy.app.coderInterviewGuide.chapter2;

/**
 * Created by tuzhenyu on 17-8-1.
 * @author tuzhenyu
 */
public class SplitList {
    public static Node splitList(Node head,int pivot){
        Node left = null;
        Node leftCur = null;
        Node middle = null;
        Node middleCur = null;
        Node right = null;
        Node rightCur = null;

        while (head!=null){
            if (head.value>pivot){
                if (rightCur == null){
                    right = head;
                    rightCur = head;
                }else {
                    rightCur.next = head;
                    rightCur = rightCur.next;
                    rightCur.next = null;
                }

            }else if (head.value==pivot){
                if (middleCur == null){
                    middle = head;
                    middleCur = head;
                }else {
                    middleCur.next = head;
                    middleCur = middleCur.next;
                    middleCur.next = right;
                }
            }else {
                if (leftCur == null){
                    left = head;
                    leftCur = head;
                }else {
                    leftCur.next = head;
                    leftCur = leftCur.next;
                    leftCur.next = middle;
                }
            }
            head = head.next;
        }
        return left;
    }

    public static Node splitListTmp(Node head,int pivot){
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next = null;
        while (head!=null){
            next = head.next;
            head.next = null;
            if (head.value<pivot){
                if (sH==null){
                    sH = head;
                    sT = head;
                }else {
                    sT.next = head;
                    sT = head;
                }
            }else if(head.value==pivot){
                if (eH==null){
                    eH = head;
                    eT = head;
                }else {
                    eT.next = head;
                    eT = head;
                }
            }else {
                if (bH==null){
                    bH = head;
                    bT = head;
                }else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        if (sT!=null){
            sT.next = eH;

        }
        if (eT!=null){
            eT.next = bH;
        }
        return sH;
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(2);
        Node node3 = new Node(6);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node head = node1;

        Node head1 = splitListTmp(head,5);

        while (head1!=null){
            System.out.println(head1.value);
            head1 = head1.next;
        }
    }
}
