package cn.tzy.app.swordoffer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by tuzhenyu on 17-11-28.
 * @author tuzhenyu
 */
public class SerializeBinaryTree {
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root==null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    private int index = -1;
    TreeNode Deserialize(String str) {
        index++;
        String[] chars = str.split(",");
        TreeNode node = null;
        if (!("#".equals(chars[index]))){
            node = new TreeNode(Integer.parseInt(chars[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }

        return node;
    }

    String Serialize2(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root==null){
            sb.append("#,");
            return sb.toString();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        sb.append(root.val+",");
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left==null){
                sb.append("#,");
            }else {
                sb.append(node.left.val+",");
                queue.add(node.left);
            }
            if (node.right==null){
                sb.append("#,");
            }else {
                sb.append(node.right.val+",");
                queue.add(node.right);
            }
        }

        return sb.toString();
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
//        node2.left = node4;
//        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        SerializeBinaryTree s = new SerializeBinaryTree();
        System.out.println(s.Serialize2(node1));
    }

}
