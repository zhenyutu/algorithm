package cn.tzy.app.swordoffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

/**
 * Created by tuzhenyu on 17-12-6.
 * @author tuzhenyu
 */
public class BinaryTreeReverseLeverPrint {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot==null)
            return res;
        ArrayList<Integer> level = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(pRoot);
        boolean flag = true;
        TreeNode nLast = null;
        TreeNode last = pRoot;
        TreeNode tmp = null;
        while (!queue.isEmpty()){
            if (flag){
                tmp = queue.pollFirst();
                level.add(tmp.val);
                if (tmp.left!=null) {
                    queue.offerLast(tmp.left);
                    nLast = nLast==null?tmp.left:nLast;
                }
                if (tmp.right!=null) {
                    queue.offerLast(tmp.right);
                    nLast = nLast==null?tmp.right:nLast;
                }
            }else {
                tmp = queue.pollLast();
                level.add(tmp.val);

                if (tmp.right!=null) {
                    queue.offerFirst(tmp.right);
                    nLast = nLast==null?tmp.right:nLast;
                }
                if (tmp.left!=null) {
                    queue.offerFirst(tmp.left);
                    nLast = nLast==null?tmp.left:nLast;
                }
            }

            if (tmp==last&&!queue.isEmpty()){
                flag = !flag;
                res.add(level);
                level = new ArrayList<>();
                last = nLast;
                nLast = null;
            }
        }
        res.add(level);
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        node4.left=null;
        node4.right=null;
        node5.left=null;
        node5.right=null;
        node6.left=null;
        node6.right=null;
        node7.left=null;
        node7.right=null;

        BinaryTreeReverseLeverPrint b = new BinaryTreeReverseLeverPrint();
        ArrayList<ArrayList<Integer>> res = b.Print(node1);
        for (int i=0;i<res.size();i++){
            ArrayList<Integer> tmp = res.get(i);
            System.out.println(tmp.toString());
        }
    }
}
