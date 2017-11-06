package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-6.
 * @author tuzhenyu
 */
public class ConvertBinaryTreeNodeList {
    private TreeNode realHead = null;
    private TreeNode pre = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null)
            return null;
        subConvert(pRootOfTree);
        return realHead;
    }

    private void subConvert(TreeNode pRootOfTree){
        if (pRootOfTree==null)
            return;
        subConvert(pRootOfTree.left);
        if (pre==null){
            pre = pRootOfTree;
            realHead = pRootOfTree;
        }else {
            pre.right = pRootOfTree;
            pRootOfTree.left = pre;
            pre = pRootOfTree;
        }
        subConvert(pRootOfTree.right);
    }
}
