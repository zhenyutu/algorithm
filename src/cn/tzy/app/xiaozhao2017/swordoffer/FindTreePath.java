package cn.tzy.app.xiaozhao2017.swordoffer;

import java.util.ArrayList;

/**
 * Created by tuzhenyu on 18-3-16.
 * @author tuzhenyu
 */
public class FindTreePath {
    ArrayList<ArrayList<TreeNode>> res = new ArrayList<>();
    public void findPath(TreeNode head,int target){
        if (head==null)
            return;
        ArrayList<TreeNode> list = new ArrayList<>();
        find(head,target,list);
    }

    private void find(TreeNode node,int target,ArrayList<TreeNode> list){
        if (node==null)
            return;
        list.add(node);
        if (target==node.val&&node.left==null&&node.right==null)
            res.add(new ArrayList<>(list));
        find(node.left,target-node.val,list);
        find(node.right,target-node.val,list);
        list.remove(list.size()-1);
    }
}
