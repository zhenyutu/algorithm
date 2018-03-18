package cn.tzy.app.xiaozhao2018.swordoffer;

/**
 * Created by tuzhenyu on 18-3-18.
 * @author tuzhenyu
 */
public class IsBalanceTree {
    public boolean isTreeBalance(TreeNode head){
        if (head==null)
            return false;
        boolean[] res = new boolean[1];
        res[0] = true;
        getHight(head,1,res);
        return res[0];
    }

    private int getHight(TreeNode node,int hight,boolean[] res){
        if (node==null)
            return hight;
        if (!res[0])
            return hight;

        int left = getHight(node.left,hight+1,res);
        if (!res[0])
            return hight;
        int right = getHight(node.right,hight+1,res);
        if (!res[0])
            return hight;

        if (Math.abs(left-right)>1)
            res[0] = false;

        return Math.max(left,right);
    }
}
