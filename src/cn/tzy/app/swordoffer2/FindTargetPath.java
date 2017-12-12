package cn.tzy.app.swordoffer2;

import java.util.ArrayList;

/**
 * Created by tuzhenyu on 17-12-12.
 * @author tuzhenyu
 */
public class FindTargetPath {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root==null)
            return res;
        ArrayList<Integer> path = new ArrayList<>();
        find(root,target,path);
        return res;
    }

    private void find(TreeNode root, int target,ArrayList<Integer> path){
        if (root==null)
            return;
        path.add(root.val);
        target -= root.val;
        if (target==0&&root.left==null&&root.right==null)
            res.add(path);
        find(root.left,target,path);
        find(root.right,target,path);

        path.remove(path.size()-1);
    }
}
