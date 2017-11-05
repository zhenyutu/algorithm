package cn.tzy.app.swordoffer;

import java.util.ArrayList;

/**
 * Created by tuzhenyu on 17-11-5.
 * @author tuzhenyu
 */
public class FindTargetPath {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root==null)
            return res;
        ArrayList<Integer> list = new ArrayList<>();
        find(root,target,list);
        return res;
    }

    private void find(TreeNode root, int target,ArrayList<Integer> list){
        if (root==null)
            return;
        list.add(root.val);
        target -= root.val;
        if (target==0&&root.left==null&&root.right==null)
            res.add(new ArrayList<>(list));
        find(root.left,target,list);
        find(root.right,target,list);
        list.remove(list.size()-1);
    }
}
