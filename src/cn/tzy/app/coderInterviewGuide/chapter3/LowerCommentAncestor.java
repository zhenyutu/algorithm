package cn.tzy.app.coderInterviewGuide.chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tuzhenyu on 18-1-9.
 * @author tuzhenyu
 */
public class LowerCommentAncestor {
    private List<TreeNode> res = new ArrayList<>();
    public TreeNode getAncestor(TreeNode root,TreeNode node1,TreeNode node2){
        if (root==null||root==node1||root==node2){
            return root;
        }
        TreeNode left = getAncestor(root.leftNode,node1,node2);
        TreeNode right = getAncestor(root.rightNode,node1,node2);

        if (left!=null&&right!=null)
            return root;
        return left==null?right:left;
    }

    public List<TreeNode> getAncestorPath(TreeNode root,TreeNode node1,TreeNode node2){
        if (root==null)
            return null;
        List<TreeNode> left = getAncestorPath(root.leftNode,node1,node2);
        List<TreeNode> right = getAncestorPath(root.rightNode,node1,node2);

        if (left==null&&right==null){
            if (root==node1||root==node2){
                List<TreeNode> list1 = new ArrayList<>();
                list1.add(root);
                return list1;
            }else {
                return null;
            }
        }else if (left!=null&&right!=null){
            res.addAll(left);
            res.add(root);
            Collections.reverse(right);
            res.addAll(right);
            return res;
        }else if (left!=null){
            left.add(root);
            if (root==node1||root==node2)
                res.addAll(left);
            return res;
        }else {
            right.add(root);
            if (root==node1||root==node2)
                res.addAll(right);
            return res;
        }

    }
}
