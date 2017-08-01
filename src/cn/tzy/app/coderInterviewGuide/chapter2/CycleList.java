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

        Node cur = head;
        int count=0;
        while (cur.next!=cur){

            if (++count==m){

            }
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
