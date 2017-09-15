package cn.tzy.app.coderInterviewGuide.chapter3;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by tuzhenyu on 17-9-15.
 * @author tuzhenyu
 */
public class IsCBT {
    public boolean isCBT(TreeNode<Integer> head){
        TreeNode<Integer> left = null;
        TreeNode<Integer> right = null;
        boolean leaf = false;
        Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(head);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            left = node.leftNode;
            right = node.rightNode;
            if ((leaf&&(left!=null||right!=null))||left==null&&right!=null)
                return false;
            if (left!=null)
                queue.add(left);
            if (right!=null)
                queue.add(right);
            else
                leaf = true;
        }

        return true;
    }
}
