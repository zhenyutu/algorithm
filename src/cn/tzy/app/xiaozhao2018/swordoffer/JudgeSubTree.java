package cn.tzy.app.xiaozhao2018.swordoffer;

/**
 * Created by tuzhenyu on 18-3-16.
 * @author tuzhenyu
 */
public class JudgeSubTree {
    public boolean judgeSubTree(TreeNode tree1,TreeNode tree2){
        if (tree1==null||tree2==null)
            return true;
        boolean res = false;
        if (tree1.val==tree2.val){
            res = isSubTree(tree1,tree2);
        }else {
            res = isSubTree(tree1.left,tree2);
            if (!res)
                res = isSubTree(tree1.right,tree2);
        }
        return res;
    }

    public boolean isSubTree(TreeNode node1,TreeNode node2){
        if (node2==null)
            return true;
        if (node1==null)
            return false;
        if (node1.val != node2.val)
            return false;
        return isSubTree(node1.left,node2.left)&&isSubTree(node1.right,node2.right);
    }
}
