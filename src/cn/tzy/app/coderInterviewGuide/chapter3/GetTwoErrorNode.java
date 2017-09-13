package cn.tzy.app.coderInterviewGuide.chapter3;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-9-13.
 * @author tuzhenyu
 */
public class GetTwoErrorNode {
    public TreeNode<Integer>[] getErrorNode(TreeNode<Integer> head){
        TreeNode<Integer>[] error = new TreeNode[2];
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> pre = null;
        while (head!=null||!stack.isEmpty()){
            while (head!=null){
                stack.push(head);
                head = head.leftNode;
            }
            head = stack.pop();
            if (pre!=null && pre.e>head.e){
                error[0] = error[0]==null?pre:error[0];
                error[1] = head;
            }
            pre = head;
            head = head.rightNode;

        }

        return error;
    }
}
