package cn.tzy.app.swordoffer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by tuzhenyu on 17-11-20.
 * @author tuzhenyu
 */
public class BinaryTreeDepth {
    public int TreeDepth(TreeNode root) {
        if (root==null)
            return 0;
        return getTreeDepth(root,0);
    }

    private int getTreeDepth(TreeNode root,int depth){
        if (root==null)
            return depth;
        int left = getTreeDepth(root.left,depth+1);
        int right = getTreeDepth(root.right,depth+1);
        return Math.max(left,right);
    }

    public int TreeDepth2(TreeNode root) {
        if (root==null)
            return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth=0;
        while (!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if (node.left!=null)
                    queue.add(node.left);
                if (node.right!=null)
                    queue.add(node.right);
            }
        }

        return depth;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        node3.left=null;
        node3.right=null;
        node4.left=null;
        node4.right=null;
        node5.left=null;
        node5.right=null;

        BinaryTreeDepth b = new BinaryTreeDepth();
        System.out.println(b.TreeDepth2(node1));
    }
}
