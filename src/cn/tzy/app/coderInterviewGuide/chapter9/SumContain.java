package cn.tzy.app.coderInterviewGuide.chapter9;

/**
 * Created by tuzhenyu on 18-1-12.
 * @author tuzhenyu
 */
public class SumContain {
    public int contain(int[] arr){
        if (arr==null||arr.length==0)
            return -1;
        int min = Integer.MAX_VALUE,max = 0;
        for (int i=0;i<arr.length;i++){
            min = Math.min(min,arr[i]);
            max += arr[i];
        }
        boolean[] dp = new boolean[max-min+1];
        for (int i=0;i<arr.length;i++){
            for (int j=max;j>=arr[i];j--){
                dp[j] = dp[j-arr[i]]?true:dp[j];
            }
        }
        for (int i=min;i<arr.length;i++){
            if (!dp[i])
                return i;
        }
        return max+1;
    }
}
