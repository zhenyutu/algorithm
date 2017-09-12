package cn.tzy.app.coderInterviewGuide.chapter3;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by tuzhenyu on 17-9-12.
 * @author tuzhenyu
 */
public class PrintByZigZag {
    public void printByZigZag(TreeNode head){
        if (head==null)
            return;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(head);
        int level = 1;
        TreeNode last = head;
        TreeNode nLast = null;
        boolean lr = true;
        printLevelAndOrientation(level++,lr);
        while (!queue.isEmpty()){
            if (lr){
                head = queue.pollFirst();
                if (head.rightNode!=null){
                    queue.add(head.rightNode);
                    nLast = head.rightNode;
                }
                if (head.leftNode!=null){
                    queue.add(head.leftNode);
                    nLast = head.leftNode;
                }
            }else {
                head = queue.pollFirst();
                if (head.leftNode!=null){
                    queue.add(head.leftNode);
                    nLast = head.leftNode;
                }
                if (head.rightNode!=null){
                    queue.add(head.rightNode);
                    nLast = head.rightNode;
                }
            }
            System.out.print(head.e + " ");

            if (head == last && !queue.isEmpty()){
                lr = !lr;
                last = nLast;
                System.out.println();
                printLevelAndOrientation(level++,lr);
            }
        }
        System.out.println();
    }

    private void printLevelAndOrientation(int level,boolean lr){
        System.out.print("Level "+ level+" from ");
        System.out.print(lr?"left to right: ":"right to left: ");
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.leftNode = node2;
        node1.rightNode = node3;
        node2.leftNode = node4;
        node2.rightNode = node5;
        node3.leftNode = node6;
        node3.rightNode = node7;

        TreeNode head = node1;
        PrintByZigZag p = new PrintByZigZag();
        p.printByZigZag(head);
    }
}
