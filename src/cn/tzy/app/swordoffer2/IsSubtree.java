package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-10.
 * @author tuzhenyu
 */
public class IsSubtree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean res = false;
        if (root1!=null&&root2!=null){
            if (root1.val==root2.val)
                res = compare(root1,root2);
            if (!res)
                res = compare(root1.left,root2);
            if (!res)
                res = compare(root1.right,root2);
        }
        return res;
    }

    private boolean compare(TreeNode root1,TreeNode root2){
        if (root2==null)
            return true;
        if (root1==null)
            return false;
        if (root1.val!=root2.val)
            return false;
        return compare(root1.left,root2.left)&compare(root1.right,root2.right);
    }
}
