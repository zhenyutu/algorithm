package cn.tzy.app.coderInterviewGuide2.chapter3.binaryTreeJudge;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by tuzhenyu on 17-12-25.
 * @author tuzhenyu
 */
public class IsFullBinaryTree {
    /**
     * 满二叉树
     * @param root
     * @return
     */
    public boolean isFullBinaryTree(TreeNode root){
        if (root!=null)
            return false;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean leaf = false;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (leaf){
                if (node.left!=null||node.right!=null)
                    return false;
            }else {
                if (node.left==null||node.right==null)
                    leaf = true;
            }
        }

        return true;
    }
}
