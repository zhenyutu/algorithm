package cn.tzy.app.xiaozhao2017.swordoffer;

/**
 * Created by tuzhenyu on 18-3-16.
 * @author tuzhenyu
 */
public class MirrorTree {
    public void mirror(TreeNode node){
        if (node==null)
            return;
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        mirror(node.left);
        mirror(node.right);
    }
}
