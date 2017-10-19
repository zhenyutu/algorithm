package cn.tzy.app.coderInterviewGuide.chapter8;

/**
 * Created by tuzhenyu on 17-10-19.
 * @author tuzhenyu
 */
public class MaxLenrthSumK {
    public int maxLength(int[] arr,int k){
        if (arr==null||arr.length==0)
            return 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        int len = 0;
        while (right<arr.length){
            if (sum==k){
                len = Math.max(len,right-left+1);
                sum-=arr[left++];
            }else if (sum<k){
                right++;
                if (right==arr.length)
                    break;
                sum+=arr[right];
            }else {
                sum-=arr[left++];
            }
        }
        return len;
    }
}
