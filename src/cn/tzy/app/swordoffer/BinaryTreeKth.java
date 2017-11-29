package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-29.
 * @author tuzhenyu
 */
public class BinaryTreeKth {
    private int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot==null)
            return null;
        TreeNode node = KthNode(pRoot.left,k);
        if (node!=null)
            return node;
        index++;
        if (index==k)
            return pRoot;
        node = KthNode(pRoot.right,k);
        return node;
    }
}
