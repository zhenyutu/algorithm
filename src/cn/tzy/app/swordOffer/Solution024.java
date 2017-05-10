package cn.tzy.app.swordOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by tuzhenyu on 17-5-10.
 * @author tuzhenyu
 */
public class Solution024 {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root==null)
            return result;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.pollFirst();
            result.add(node.val);

            if (node.left!=null)
                queue.add(node.left);
            if (node.right!=null)
                queue.add(node.right);
        }

        return result;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
        TreeNode root = null;
        System.out.println(PrintFromTopToBottom(root).toString());
    }
}
