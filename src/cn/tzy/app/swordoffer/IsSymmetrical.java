package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-27.
 * @author tuzhenyu
 */
public class IsSymmetrical {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot==null)
            return true;
        return compare(pRoot.left,pRoot.right);
    }

    private boolean compare(TreeNode left,TreeNode right){
        if (left==null)
            return right==null;
        if (right==null)
            return false;
        if (left.val!=right.val)
            return false;
        return compare(left.left,right.right)&&compare(left.right,right.left);
    }
}
