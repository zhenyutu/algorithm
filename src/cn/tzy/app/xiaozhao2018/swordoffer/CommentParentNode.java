package cn.tzy.app.xiaozhao2018.swordoffer;

/**
 * Created by tuzhenyu on 18-3-18.
 * @author tuzhenyu
 */
public class CommentParentNode {
    public TreeNode getCommentNode(TreeNode node,TreeNode p,TreeNode q){
        if (node==null||node==p||node==q)
            return node;
        TreeNode left = getCommentNode(node.left,p,q);
        TreeNode right = getCommentNode(node.right,p,q);

        if (left!=null&&right!=null)
            return node;

        return left==null?right:left;
    }
}
