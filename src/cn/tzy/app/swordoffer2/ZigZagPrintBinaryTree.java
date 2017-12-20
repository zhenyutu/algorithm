package cn.tzy.app.swordoffer2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

/**
 * Created by tuzhenyu on 17-12-20.
 * @author tuzhenyu
 */
public class ZigZagPrintBinaryTree {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot==null)
            return res;
        boolean flag = true;
        TreeNode last=pRoot,nLast=null;
        TreeNode node = pRoot;
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(pRoot);
        while (!queue.isEmpty()){
            if (flag){
                node = queue.pollFirst();
                list.add(node.val);

                if (node.left!=null) {
                    queue.offerLast(node.left);
                    nLast = nLast==null?node.left:nLast;
                }
                if (node.right!=null) {
                    queue.offerLast(node.right);
                    nLast = nLast==null?node.right:nLast;
                }

            }else {
                node = queue.pollLast();
                list.add(node.val);

                if (node.right!=null){
                    queue.offerFirst(node.right);
                    nLast = nLast==null?node.right:nLast;
                }
                if (node.left!=null){
                    queue.offerFirst(node.left);
                    nLast = nLast==null?node.left:nLast;
                }
            }

            if (node==last&&!queue.isEmpty()){
                flag = !flag;
                res.add(list);
                list = new ArrayList<>();
                last = nLast;
                nLast = null;
            }
        }
        res.add(list);
        return res;
    }
}
