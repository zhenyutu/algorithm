package cn.tzy.app.xiaozhao2018.swordoffer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by tuzhenyu on 18-3-16.
 * @author tuzhenyu
 */
public class PrintTreeLevel {
    public void printLevel(TreeNode head){
        if (head==null)
            return;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(head);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left!=null)
                queue.add(node.left);
            if (node.right!=null)
                queue.add(node.right);
        }
    }
}
