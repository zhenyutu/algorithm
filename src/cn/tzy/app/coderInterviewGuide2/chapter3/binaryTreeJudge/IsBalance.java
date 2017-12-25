package cn.tzy.app.coderInterviewGuide2.chapter3.binaryTreeJudge;



/**
 * Created by tuzhenyu on 17-12-25.
 * @author tuzhenyu
 */
public class IsBalance {
    private boolean isBalance(TreeNode node){
        if (node==null)
            return false;
        boolean[] res = new boolean[1];
        res[0] = true;
        getHigh(node,1,res);

        return res[0];
    }

    private int getHigh(TreeNode node,int level,boolean[] res){
        if (node==null)
            return level;
        int left = getHigh(node.left,level+1,res);
        if (!res[0])
            return level;
        int right = getHigh(node.right,level+1,res);
        if (!res[0])
            return level;

        if (Math.abs(left-right)>1)
            res[0] = false;

        return Math.max(left,right);
    }
}
