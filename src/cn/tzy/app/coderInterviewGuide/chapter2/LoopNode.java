package cn.tzy.app.coderInterviewGuide.chapter2;

/**
 * Created by tuzhenyu on 17-8-10.
 * @author tuzhenyu
 */
public class LoopNode {
    /**
     * 判断链表是否有环
     * @param head
     * @return
     */
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

    /**
     * 获取带环链表的接入节点
     * @param head
     * @return
     */
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

    /**
     * 判断两个无环链表是否相交
     * @param head1
     * @param head2
     * @return
     */
    public static Node isFixed(Node head1,Node head2){
        int tmp;
        int len1 = 0;
        int len2 = 0;
        Node lastNode1 = head1;
        while (lastNode1.next!=null){
            len1++;
            lastNode1 = lastNode1.next;
        }
        Node lastNode2 = head2;
        while (lastNode2.next!=null){
            len2++;
            lastNode2 = lastNode2.next;
        }
        if(lastNode1!=lastNode2)
            return null;
        Node cur1;
        Node cur2;
        if (len1>len2){
            tmp = len1-len2;
            cur1 = head1;
            cur2 = head2;
        }else {
            tmp = len2-len1;
            cur1 = head2;
            cur2 = head1;
        }

        while (tmp>0){
            tmp--;
            cur1 = cur1.next;
        }

        while (cur1!=cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     *　判断两个有环链表是否相交
     * @param head1
     * @param head2
     * @return
     */
    public static Node isFixed2(Node head1,Node loop1,Node head2,Node loop2){
        int tmp;
        int len1 = 0;
        int len2 = 0;

        Node cur1;
        Node cur2;

        if (loop1==loop2){
            Node lastNode1 = head1;
            while (lastNode1!=loop1){
                len1++;
                lastNode1 = lastNode1.next;
            }
            Node lastNode2 = head2;
            while (lastNode2!=loop2){
                len2++;
                lastNode2 = lastNode2.next;
            }

            if (len1>len2){
                tmp = len1-len2;
                cur1 = head1;
                cur2 = head2;
            }else {
                tmp = len2-len1;
                cur1 = head2;
                cur2 = head1;
            }

            while (tmp>0){
                tmp--;
                cur1 = cur1.next;
            }

            while (cur1!=cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            cur1 = loop1.next;
            while (cur1!=loop1){
                if (cur1==loop2)
                    return loop1;
                cur1 = cur1.next;
            }
            return null;
        }
    }

    /**
     * 判断任意类型的链表是否相交，如果相交的话返回交点
     * @param head1
     * @param head2
     * @return
     */
    public static Node getIntersectNode(Node head1,Node head2){
        if (head1==null||head2==null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1==null&&loop2==null){
            return isFixed(head1,head2);
        }
        if (loop1!=null&&loop2!=null){
            return isFixed2(head1,loop1,head2,loop2);
        }
        return null;
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node0 = new Node(0);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node2;
        node0.next = node2;
        Node head = node1;

//        System.out.println(hasLoop(head));
//        System.out.println(getLoopNode(head).value);
        System.out.println(isFixed(node0,node1).value);

    }
}
