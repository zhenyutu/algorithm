package cn.tzy.app.xiaozhao2018.leetcode;



/**
 * Created by tuzhenyu on 18-3-25.
 * @author tuzhenyu
 */
public class MinDepthTree {
    public int minDepth(TreeNode root){
        if (root==null)
            return 0;
        return getMin(root,1);
    }

    private int getMin(TreeNode node,int depth){
        if (node==null)
            return depth-1;
        if (node.left==null)
            return getMin(node.right,depth+1);
        else if (node.right==null)
            return getMin(node.left,depth+1);
        else
            return Math.min(getMin(node.left,depth+1),getMin(node.right,depth+1));
    }
}
