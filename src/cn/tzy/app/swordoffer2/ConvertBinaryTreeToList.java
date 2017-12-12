package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-12.
 * @author tuzhenyu
 */
public class ConvertBinaryTreeToList {
    private TreeNode head=null;
    private TreeNode pre=null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null)
            return null;
        subConvert(pRootOfTree);
        return head;
    }

    private void subConvert(TreeNode pRootOfTree){
        if (pRootOfTree==null)
            return;
        subConvert(pRootOfTree.left);
        if (head==null){
            head = pRootOfTree;
            pre = pRootOfTree;
        }else {
            pre.right = pRootOfTree;
            pRootOfTree.left = pre;
            pre = pRootOfTree;
        }
        subConvert(pRootOfTree.right);
    }
}
