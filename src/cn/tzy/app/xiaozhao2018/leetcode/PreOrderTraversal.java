package cn.tzy.app.xiaozhao2018.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by tuzhenyu on 18-3-25.
 * @author tuzhenyu
 */
public class PreOrderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root==null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right!=null)
                stack.push(node.right);
            if (node.left!=null)
                stack.push(node.left);
        }

        return list;
    }
}
