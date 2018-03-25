package cn.tzy.app.xiaozhao2018.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by tuzhenyu on 18-3-25.
 * @author tuzhenyu
 */
public class PostOrderTraversal {
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if (root==null)
            return list;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    public ArrayList<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root==null)
            return list;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left!=null)
                stack1.push(node.left);
            if (node.right!=null)
                stack1.push(node.right);
        }
        while (!stack2.isEmpty()){
            list.add(stack2.pop().val);
        }
        return list;
    }
}
