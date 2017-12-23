package cn.tzy.app.coderInterviewGuide2.chapter3;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by tuzhenyu on 17-12-22.
 * @author tuzhenyu
 */
class TreeNode<E>{
    E e;
    TreeNode<E> leftNode,rightNode;

    public TreeNode(E e){
        this.e = e;
        this.leftNode = null;
        this.rightNode = null;
    }

}
public class BinaryTreeIterator {
    public void midOrder(TreeNode<Integer> root){
        if (root==null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.leftNode;
            }
            TreeNode node = stack.pop();
            System.out.println(node.e);
            root = node.rightNode;
        }
    }

    public void postOrder(TreeNode root){
        if (root==null)
            return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);

            if (node.rightNode!=null)
                stack1.push(node.rightNode);
            if (node.leftNode!=null)
                stack1.push(node.rightNode);
        }

        while (!stack2.isEmpty()){
            TreeNode node = stack2.pop();
            System.out.println(node.e);
        }

    }
}
