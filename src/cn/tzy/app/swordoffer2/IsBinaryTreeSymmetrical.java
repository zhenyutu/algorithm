package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-20.
 * @author tuzhenyu
 */
public class IsBinaryTreeSymmetrical {
    boolean isSymmetrical(TreeNode pRoot){
        if (pRoot==null)
            return true;
        return judge(pRoot.left,pRoot.right);
    }

    private boolean judge(TreeNode left,TreeNode right){
        if (left==null)
            return right==null;
        if (right==null)
            return false;

        if (left.val!=right.val)
            return false;

        return judge(left.left,right.right)&&judge(left.right,right.left);
    }
}
