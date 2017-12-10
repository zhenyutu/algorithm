package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-10.
 * @author tuzhenyu
 */
public class BinaryTreeMirror {
    public void Mirror(TreeNode root) {
        if (root==null)
            return;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        Mirror(root.left);
        Mirror(root.right);
    }

    public void Mirror2(TreeNode root) {
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
