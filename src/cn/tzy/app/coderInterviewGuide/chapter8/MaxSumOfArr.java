package cn.tzy.app.coderInterviewGuide.chapter8;

/**
 * Created by tuzhenyu on 17-10-23.
 * @author tuzhenyu
 */
public class MaxSumOfArr {
    public int maxSum(int[] arr){
        if (arr==null||arr.length==0)
            return 0;
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            cur += arr[i];
            max = Math.max(max,cur);
            cur = cur<0?0:cur;
        }
        return max;
    }
}
