package cn.tzy.app.coderInterviewGuide.chapter3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * Created by tuzhenyu on 17-9-2.
 * @author tuzhenyu
 */
public class SerialBinaryTree {
    public String serialByPreOrder(TreeNode root){
        if (root==null){
            return "!#";
        }
        String res = root.e + "!";
        res += serialByPreOrder(root.leftNode);
        res += serialByPreOrder(root.rightNode);
        return res;
    }

    public TreeNode reconPreString(String preStr){
        String[] strs = preStr.split("!");
        Deque<String> queue = new ArrayDeque<>();
        for (int i=0;i<strs.length;i++){
            queue.offer(strs[i]);
        }

        return reconPreOrder(queue);
    }

    private TreeNode reconPreOrder(Deque<String> queue){
        String str = queue.poll();
        if ("#".equals(str))
            return null;
        TreeNode node = new TreeNode(str);
        node.leftNode = reconPreOrder(queue);
        node.rightNode = reconPreOrder(queue);

        return node;
    }
}
