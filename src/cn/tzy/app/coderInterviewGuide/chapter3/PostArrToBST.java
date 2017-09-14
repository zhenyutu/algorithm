package cn.tzy.app.coderInterviewGuide.chapter3;

/**
 * Created by tuzhenyu on 17-9-14.
 * @author tuzhenyu
 */
public class PostArrToBST {
    public TreeNode postArrToBST(int[] arr){
        if (arr==null||arr.length==0)
            return null;
        return postToBST(arr,0,arr.length-1);
    }

    private TreeNode<Integer> postToBST(int[] arr,int start,int end){
        if (start>end)
            return null;
        int pre = -1;
        int post = end;
        TreeNode<Integer> head = new TreeNode<>(arr[end]);
        for (int i=start;i<end;i++){
            if (arr[i]<arr[end]){
                pre = i;
            }else {
                post = i;
                break;
            }
        }
        head.leftNode = postToBST(arr,start,pre);
        head.rightNode = postToBST(arr,post,end-1);
        return head;
    }
}
