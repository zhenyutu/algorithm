package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-21.
 * @author tuzhenyu
 */
public class GetKthNodeSortedBinaryTree {
    private int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k){
        if (pRoot==null)
            return null;
        TreeNode node = KthNode(pRoot.left,k);
        if (node!=null)
            return node;
        index++;
        if (k==index)
            return pRoot;
        node = KthNode(pRoot.right,k);
        return node;
    }
}
