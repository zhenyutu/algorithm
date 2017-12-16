package cn.tzy.app.swordoffer2;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by tuzhenyu on 17-12-16.
 * @author tuzhenyu
 */
public class getTreeDepth {
    public int TreeDepth(TreeNode root) {
        if (root==null)
            return 0;
        return Math.max(getDepth(root.left,1),getDepth(root.right,1));
    }

    private int getDepth(TreeNode node,int depth){
        if (node==null)
            return depth;
        return Math.max(getDepth(node.left,depth+1),getDepth(node.right,depth+1));
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
}
