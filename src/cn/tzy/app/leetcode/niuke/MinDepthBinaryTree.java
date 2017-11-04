package cn.tzy.app.leetcode.niuke;

/**
 * Created by tuzhenyu on 17-11-3.
 * @author tuzhenyu
 */
public class MinDepthBinaryTree {
    public int run(TreeNode root) {
        if (root==null)
            return 0;
        if (root.left==null&&root.right==null)
            return 1;
        if (root.left==null)
            return run(root.right)+1;
        else if (root.right==null)
            return run(root.left)+1;
        else
            return Math.min(run(root.left),run(root.right))+1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;

        TreeNode head = node1;
        MinDepthBinaryTree m = new MinDepthBinaryTree();
        System.out.println(m.run(head));
    }
}
