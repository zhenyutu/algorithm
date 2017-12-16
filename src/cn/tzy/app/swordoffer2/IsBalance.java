package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-16.
 * @author tuzhenyu
 */
public class IsBalance {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null)
            return true;
        boolean[] res = new boolean[1];
        res[0] = true;
        getHigh(root,1,res);
        return res[0];
    }

    private int getHigh(TreeNode root,int depth,boolean[] res){
        if (root==null)
            return depth;
        int left = getHigh(root.left,depth+1,res);
        if (!res[0])
            return depth;
        int right = getHigh(root.right,depth+1,res);
        if (!res[0])
            return depth;

        if (Math.abs(left-right)>1)
            res[0] = false;

        return Math.max(left,right);
    }

    public boolean IsBalanced_Solution2(TreeNode root) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHight2(root,0,res);
        return res[0];
    }

    private int getHight2(TreeNode root,int depth,boolean[] res){
        if (root==null)
            return depth;
        int left = getHight2(root.left,depth+1,res);
        if (!res[0])
            return depth;
        int right = getHight2(root.right,depth+1,res);
        if (!res[0])
            return depth;
        if (Math.abs(left-right)>1)
            res[0] = false;
        return Math.max(left,right);
    }
}
