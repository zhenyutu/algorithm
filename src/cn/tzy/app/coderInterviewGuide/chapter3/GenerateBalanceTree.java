package cn.tzy.app.coderInterviewGuide.chapter3;

/**
 * Created by tuzhenyu on 17-9-15.
 * @author tuzhenyu
 */
public class GenerateBalanceTree {
    public TreeNode generateTree(int[] arr){
        TreeNode head = generate(arr,0,arr.length-1);
        return head;
    }

    private TreeNode generate(int[] arr,int start,int end){
        if (start>end)
            return null;
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(mid);
        node.leftNode = generate(arr,0,mid-1);
        node.rightNode = generate(arr,mid+1,arr.length-1);
        return node;
    }
}
