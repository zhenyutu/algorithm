package cn.tzy.app.swordOffer;

/**
 * Created by tuzhenyu on 17-5-7.
 * @author tuzhenyu
 */
public class Solution020 {
    /**
     *在二叉树原地改变左右指针指向，类似于链表的反向输出原地转向
     * 32ms 692k
     */
    public void Mirror(TreeNode root) {
        if (root==null)
            return;
        if (root.left!=null||root.right!=null){
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            if (root.left!=null)
                Mirror(root.left);
            if (root.right!=null)
                Mirror(root.right);
        }
    }
}
