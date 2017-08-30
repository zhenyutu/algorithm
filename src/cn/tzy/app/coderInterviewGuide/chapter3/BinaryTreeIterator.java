package cn.tzy.app.coderInterviewGuide.chapter3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by tuzhenyu on 17-8-29.
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
    /**
     *利用递归的二叉树遍历
     */

    public void preOrder(TreeNode head){
        if (head==null)
            return;
        System.out.println( head.e);
        preOrder(head.leftNode);
        preOrder(head.rightNode);

    }

    public void midOrder(TreeNode head){
        if (head==null)
            return;
        preOrder(head.leftNode);
        System.out.println( head.e);
        preOrder(head.rightNode);
    }

    public void postOrder(TreeNode head){
        if (head==null)
            return;
        preOrder(head.leftNode);
        preOrder(head.rightNode);
        System.out.println( head.e);
    }

    /**
     * 利用栈的特性实现二叉树的遍历
     */
    public void preOrder2(TreeNode root){
        if (root==null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node  = stack.pop();
            System.out.println(node.e);
            if (node.rightNode!=null)
                stack.push(node.rightNode);
            if (node.leftNode!=null)
                stack.push(node.leftNode);
        }
    }

    public void midOrder2(TreeNode root){
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

    public void postOrder2(TreeNode root){
        if (root==null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisit = root;
        TreeNode node = root;
        while (node!=null||!stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                node = node.leftNode;
            }
            node = stack.peek();
            if (node.rightNode==null||node.rightNode==lastVisit){
                System.out.println(node.e);
                stack.pop();
                lastVisit = node;
                node = null;
            }else {
                node = node.rightNode;
            }
        }
    }

    public void postOrder3(TreeNode root){
        if (root==null)
            return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.leftNode!=null)
                stack1.push(node.rightNode);
            if (node.rightNode!=null)
                stack1.push(node.leftNode);
        }
        while (!stack2.isEmpty()){
            TreeNode node = stack2.pop();
            System.out.println(node.e);
        }
    }

    public void level(TreeNode root){
        if (root==null)
            return;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        if (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.e);
            if (node.leftNode!=null)
                queue.add(node.leftNode);
            if (node.rightNode!=null)
                queue.add(node.rightNode);
        }
    }
}
