package cn.tzy.app.coderInterviewGuide2.chapter3;

/**
 * Created by tuzhenyu on 17-12-24.
 * @author tuzhenyu
 */
public class ContainBinaryTree {

    public boolean containBinaryTree(TreeNode root,TreeNode node){
        if (root==null||node==null)
            return false;
        boolean[] res = new boolean[1];
        res[0] = false;
        return check(root,node,res);
    }
    public boolean check(TreeNode root,TreeNode node,boolean[] res){
        if (root==null)
            return false;

        res[0] = contain(root.leftNode,node);
        if (res[0])
            return true;

        res[0] = contain(root.rightNode,node);
        if (res[0])
            return true;

        return check(root.leftNode,node,res)||check(root.rightNode,node,res);
    }

    private boolean contain(TreeNode root,TreeNode node){
        if (node==null)
            return true;
        if (root==null||root.e!=node.e)
            return false;

        return contain(root.leftNode,node.leftNode)&&contain(root.rightNode,node.rightNode);
    }
}
