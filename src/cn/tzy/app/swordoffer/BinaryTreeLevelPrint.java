package cn.tzy.app.swordoffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by tuzhenyu on 17-11-27.
 * @author tuzhenyu
 */
public class BinaryTreeLevelPrint {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot==null)
            return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(pRoot);
        TreeNode last = pRoot;
        TreeNode nLast = null;
        ArrayList<Integer> tmp = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            tmp.add(node.val);
            if (node.left!=null) {
                queue.add(node.left);
                nLast = node.left;
            }
            if (node.right!=null) {
                queue.add(node.right);
                nLast = node.right;
            }
            if (node==last&&!queue.isEmpty()){
                res.add(tmp);
                tmp = new ArrayList<>();
                last = nLast;
            }
        }
        res.add(tmp);
        return res;
    }
}
