package cn.tzy.app.xiaozhao2018.swordoffer;

/**
 * Created by tuzhenyu on 18-3-18.
 * @author tuzhenyu
 */
public class GetTreeDepth {
    public int getTreeDepth(TreeNode head){
        if (head==null)
            return 0;
        return Math.max(getDepth(head.left,1),getDepth(head.right,1));
    }

    private int getDepth(TreeNode node,int depth){
        if (node==null)
            return depth;
        return Math.max(getDepth(node.left,depth+1),getDepth(node.right,depth+1));
    }
}
