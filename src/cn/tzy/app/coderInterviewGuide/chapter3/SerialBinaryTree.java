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

    public String serialByLevel(TreeNode root){
        Deque<TreeNode> queue = new ArrayDeque<>();
        String res = root.e + "!";
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.leftNode!=null){
                res += node.leftNode.e;
                queue.add(node.leftNode);
            }else {
                res += "#!";
            }
            if (node.rightNode!=null){
                res += node.rightNode.e;
                queue.add(node.rightNode);
            }else {
                res += "#!";
            }
        }

        return res;
    }

    public TreeNode reconLevel(String str){
        String[] strs = str.split("!");
        int index=0;
        TreeNode head = generateNodeByString(strs[index++]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (head!=null){
            queue.add(head);
        }
        TreeNode node = null;
        while (!queue.isEmpty()){
            node = queue.poll();
            node.leftNode = generateNodeByString(strs[index++]);
            node.rightNode = generateNodeByString(strs[index++]);
            if (node.leftNode!=null)
                queue.add(node.leftNode);
            if (node.rightNode!=null)
                queue.add(node.rightNode);
        }

        return head;

    }

    private TreeNode generateNodeByString(String str){
        if ("#".equals(str))
            return null;
        return new TreeNode(str);
    }
}
