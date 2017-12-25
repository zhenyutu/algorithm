package cn.tzy.app.coderInterviewGuide2.chapter3.binaryTreeJudge;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by tuzhenyu on 17-12-25.
 * @author tuzhenyu
 */
public class IsCBT {
    /**
     * 完全二叉树
     * @param root
     * @return
     */
    public boolean isCBT(TreeNode root){
        if (root==null)
            return false;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean leaf = false;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;

            if ((leaf&&(left!=null||right!=null))||(left==null&&right!=null))
                return false;
            if (left!=null)
                queue.add(left);
            else
                leaf = true;

            if (right!=null)
                queue.add(right);
            else
                leaf = true;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
//        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
//        node3.left = node6;
        node3.right = node7;

        IsCBT is = new IsCBT();
        System.out.println(is.isCBT(node1));
    }
}
