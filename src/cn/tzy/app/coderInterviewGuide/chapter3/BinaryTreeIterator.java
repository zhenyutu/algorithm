package cn.tzy.app.coderInterviewGuide.chapter3;

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
        
    }

    public void midOrder2(TreeNode root){

    }

    public void postOrder2(TreeNode root){

    }
}
