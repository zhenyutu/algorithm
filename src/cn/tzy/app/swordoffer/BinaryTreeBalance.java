package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-20.
 * @author tuzhenyu
 */
public class BinaryTreeBalance {
    public boolean IsBalanced_Solution(TreeNode root) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHight(root,0,res);
        return res[0];
    }

    private int getHight(TreeNode root,int depth,boolean[] res){
        if (root==null)
            return depth;
        int left = getHight(root.left,depth+1,res);
        if (!res[0])
            return depth;
        int right = getHight(root.right,depth+1,res);
        if (!res[0])
            return depth;
        if (Math.abs(left-right)>1)
            res[0] = false;
        return Math.max(left,right);
    }
}
