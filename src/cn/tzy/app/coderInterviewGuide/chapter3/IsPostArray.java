package cn.tzy.app.coderInterviewGuide.chapter3;

/**
 * Created by tuzhenyu on 17-9-14.
 * @author tuzhenyu
 */
public class IsPostArray {
    public boolean isPostArray(int[] arr){
        if (arr==null || arr.length==0)
            return false;
        return isPost(arr,0,arr.length-1);
    }

    private boolean isPost(int[] arr,int start,int end){
        if (start==end)
            return true;
        int pre = -1;
        int post = end;
        for (int i=start;i<end;i++){
            if (arr[i]<arr[end]){
                pre = i;
            }else {
                post = i;
                break;
            }
        }
        if (pre==-1||post==start){
            return isPost(arr,start,end-1);
        }
        if (pre!=post-1)
            return false;
        return isPost(arr,start,pre) && isPost(arr,post,end-1);
    }
}
