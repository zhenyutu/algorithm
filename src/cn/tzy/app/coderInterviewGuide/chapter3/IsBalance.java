package cn.tzy.app.coderInterviewGuide.chapter3;

/**
 * Created by tuzhenyu on 17-9-6.
 * @author tuzhenyu
 */
public class IsBalance {
    public boolean isBalance(TreeNode head){
        boolean[] res  = new boolean[1];
        res[0] = true;
        getHeight(head,1,res);
        return res[0];
    }

    private int getHeight(TreeNode node,int level,boolean[] res){
        if (node== null)
            return level;
        int leftLevel = getHeight(node.leftNode,level+1,res);
        if (!res[0])
            return level;
        int rightLevel = getHeight(node.rightNode,level+1,res);
        if (!res[0])
            return level;
        if (Math.abs(leftLevel-rightLevel)>1)
            res[0] = false;

        return Math.max(rightLevel,leftLevel);
    }
}
