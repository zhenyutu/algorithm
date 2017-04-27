package cn.tzy.app.swordOffer;

/**
 * Created by tuzhenyu on 17-4-27.
 * @author tuzhenyu
 */
public class Solution006 {
     static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode(int x) {
             val = x;
         }
     }

    /**
     *根据二叉树前序遍历结果和中序遍历结果倒推二叉树
     *前序遍历的第一位是根节点，根据根节点在中序遍历中根节点的位置划分左右子树,再对子树进行递归
     */
     public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = createBinaryTree(pre,in,0,pre.length-1,0,in.length-1);
        return root;
     }

     private static TreeNode createBinaryTree(int[] pre,int[] mid,int preStart,int preEnd,int midStart,int midEnd){
         int rootIndex = 0;
         for (int i=midStart;i<=midEnd;i++){
             if(pre[preStart]==mid[i]){
                 rootIndex = i;
                 break;
             }
         }
         TreeNode root = new TreeNode(mid[rootIndex]);
         if(rootIndex!=midStart){
             root.left = createBinaryTree(pre,mid,preStart+1,preStart+rootIndex-midStart,midStart,rootIndex-1);
         }else {
             root.left = null;
         }

        if(rootIndex!=midEnd){
             root.right = createBinaryTree(pre,mid,preStart+rootIndex-midStart+1,preEnd,rootIndex+1,midEnd);
         }else {
             root.right = null;
         }

         return root;
     }

     public static void postOrder(TreeNode root){
        if (root == null)
            return;
        postOrder(root.left);
        System.out.print(root.val+" ");
        postOrder(root.right);
     }

    public static void main(String[] args) {
        int[] arr1 = {1,2,4,7,3,5,6,8};
        int[] arr2 = {4,7,2,1,5,3,8,6};
        TreeNode node = reConstructBinaryTree(arr1,arr2);
        postOrder(node);
    }
}
