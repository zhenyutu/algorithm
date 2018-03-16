package cn.tzy.app.xiaozhao2017.swordoffer;

/**
 * Created by tuzhenyu on 18-3-16.
 * @author tuzhenyu
 */
public class ConvertTreeToList {
    TreeNode pre = null;
    TreeNode realHead = null;
    public TreeNode convertTree(TreeNode head){
        if (head==null)
            return head;
        convertTree(head);
        return realHead;
    }

    private void convert(TreeNode node){
        if (node==null)
            return;
        convertTree(node.left);
        if (pre == null){
            pre = node;
            realHead = node;
        }else {
            pre.right = node;
            node.left = pre;
            pre = node;
        }
        convertTree(node.right);
    }
}
