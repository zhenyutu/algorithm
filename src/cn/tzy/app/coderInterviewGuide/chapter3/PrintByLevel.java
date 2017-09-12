package cn.tzy.app.coderInterviewGuide.chapter3;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by tuzhenyu on 17-9-12.
 * @author tuzhenyu
 */
public class PrintByLevel {
    public void printByLevel(TreeNode head){
        if (head==null)
            return;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(head);
        int level = 1;
        TreeNode last = head;
        TreeNode nLast = null;
        System.out.println("Level "+ level++ +" :");
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.e + " ");
            if (node.leftNode!=null){
                queue.add(node.leftNode);
                nLast = node.leftNode;
            }
            if (node.rightNode != null){
                queue.add(node.rightNode);
                nLast = node.rightNode;
            }
            if (head==last&&!queue.isEmpty()){
                System.out.println("Level "+ level++ +" :");
                last = nLast;
            }
        }
        System.out.println();
    }
}
