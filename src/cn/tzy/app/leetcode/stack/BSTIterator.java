package cn.tzy.app.leetcode.stack;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-8-18.
 * @author tuzhenyu
 * leetcode_173
 */


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

/**
 * 二分查找树,最小值为最左侧的孩子；
 * 这道题的本质是用栈实现二叉树的中序遍历；
 */
public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        while (root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pop();
        TreeNode right = node.right;
        if (right!=null){
            while (right!=null){
                stack.push(right);
                right = right.left;
            }
        }
        return node.val;
    }
}
