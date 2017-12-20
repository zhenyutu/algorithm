package cn.tzy.app.swordoffer2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by tuzhenyu on 17-12-20.
 * @author tuzhenyu
 */
public class PrintBinaryTreeLevel {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot==null)
            return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode nLast = pRoot,last = pRoot;
        queue.add(pRoot);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left!=null){
                queue.add(node.left);
                nLast = node.left;
            }

            if (node.right!=null){
                queue.add(node.right);
                nLast = node.right;
            }

            if (last==node&&!queue.isEmpty()){
                res.add(list);
                list = new ArrayList<>();
                last = nLast;
            }
        }
        res.add(list);
        return res;
    }
}
