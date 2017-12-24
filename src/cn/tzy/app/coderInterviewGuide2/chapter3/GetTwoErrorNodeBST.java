package cn.tzy.app.coderInterviewGuide2.chapter3;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-12-24.
 * @author tuzhenyu
 */
public class GetTwoErrorNodeBST {
    public TreeNode<Integer>[] getTwoErrorNodes(TreeNode<Integer> root){
        TreeNode<Integer>[] res = new TreeNode[2];
        if (root==null)
            return res;
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);
        TreeNode<Integer> pre = null;
        while (root!=null||!stack.isEmpty()){
            if (root!=null){
                stack.push(root);
                root = root.leftNode;
            }else {
                root = stack.pop();
                if (pre!=null&&pre.e>root.e){
                    res[0] = res[0]==null?pre:res[0];
                    res[1] = root;
                }
                pre = root;
                root = root.rightNode;
            }
        }

        return res;
    }
}
