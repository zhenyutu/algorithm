package cn.tzy.app.coderInterviewGuide2.chapter3;

/**
 * Created by tuzhenyu on 17-12-23.
 * @author tuzhenyu
 */
public class MaxSubBST {
    public TreeNode<Integer> getMaxSubBST(TreeNode<Integer> root){
        if (root==null)
            return root;
        int[] res = new int[3];
        return postOrder(root,res);
    }

    private TreeNode<Integer> postOrder(TreeNode<Integer> root,int[] res){
        if (root==null){
            res[0] = 0;
            res[1] = Integer.MAX_VALUE;
            res[2] = Integer.MIN_VALUE;
        }

        TreeNode<Integer> left = root.leftNode;
        TreeNode<Integer> right = root.rightNode;

        TreeNode lBST = postOrder(left,res);
        int lBSTSize = res[0];
        int lBSTMin = res[1];
        int lBSTMax = res[2];

        TreeNode rBST = postOrder(right,res);
        int rBSTSize = res[0];
        int rBSTMin = res[1];
        int rBSTMax = res[2];

        res[1] = Math.min(root.e,lBSTMin);
        res[2] = Math.max(root.e,rBSTMax);

        if (left==lBST&&right==rBST&&lBSTMax<root.e&&rBSTMin>root.e){
            res[0] = lBSTSize + rBSTSize + 1;
            return root;
        }

        res[0] = Math.max(lBSTSize,rBSTSize);
        return lBSTSize>rBSTSize?left:right;
    }
}
