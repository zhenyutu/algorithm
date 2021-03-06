package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-2.
 * @author tuzhenyu
 */
public class MirrorBinaryTree {
    public void Mirror(TreeNode root) {
        if (root==null)
            return;
        if (root.left==null&&root.right==null)
            return;

        if (root.left!=null)
            Mirror(root.left);
        if (root.right!=null)
            Mirror(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
