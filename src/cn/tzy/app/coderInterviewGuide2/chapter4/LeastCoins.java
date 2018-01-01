package cn.tzy.app.coderInterviewGuide2.chapter4;

/**
 * Created by tuzhenyu on 18-1-1.
 * @author tuzhenyu
 */
public class LeastCoins {
    public int leastCoins(int[] arr,int arm){
        if (arr==null||arr.length==0||arm<0)
            return -1;
        int[] dp = new int[arm+1];
        for (int i=1;i<dp.length;i++){
            dp[i] = i;
        }
        for (int i=1;i<dp.length;i++){
            for (int j=0;j<arr.length;j++){
                if (i>arr[j]&&dp[i-arr[j]]+1<dp[i]){
                    dp[i] = dp[i-arr[j]]+1;
                }
            }
        }

        return dp[arm];
    }
}
