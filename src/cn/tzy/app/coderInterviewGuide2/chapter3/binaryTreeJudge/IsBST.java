package cn.tzy.app.coderInterviewGuide2.chapter3.binaryTreeJudge;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-12-25.
 * @author tuzhenyu
 */
public class IsBST {
    public boolean isBST(TreeNode node){
        if (node==null)
            return false;
        Stack<TreeNode> stack = new Stack<>();
        int pre = Integer.MIN_VALUE;
        while (!stack.isEmpty()||node!=null){
            while (node!=null){
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            System.out.print(node.val+" ");
            if (pre>node.val)
                return false;
            else {
                pre = node.val;
                node = node.right;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        IsBST isBST = new IsBST();
        System.out.println(isBST.isBST(node1));
    }
}
