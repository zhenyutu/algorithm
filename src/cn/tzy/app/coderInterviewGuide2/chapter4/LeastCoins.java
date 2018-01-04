package cn.tzy.app.coderInterviewGuide2.chapter4;

/**
 * Created by tuzhenyu on 18-1-4.
 * @author tuzhenyu
 */
public class LeastCoins {
    public int leastCoins(int[] coins,int target){
        if (coins==null||coins.length==0||target<0)
            return -1;
        int[] dp = new int[target+1];
        for (int i=0;i<dp.length;i++){
            dp[i] = i;
        }
        for (int i=0;i<=target;i++){
            for (int j=0;j<coins.length;j++){
                if (i>=coins[j]&&(dp[i-coins[j]]+1<dp[i])){
                    dp[i] = dp[i-coins[j]]+1;
                }
            }
        }

        return dp[target];
    }

    public int leastCoins1(int[] coins,int target){
        if (coins==null||coins.length==0||target<0)
            return -1;
        int[] dp = new int[target+1];
        for (int i=0;i<dp.length;i++){
            dp[i] = i;
        }
        for (int i=1;i<=target;i++){
            for (int j=0;j<coins.length;j++){
                if (i>=coins[j]){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,3,5};
        int target = 15;
        LeastCoins l = new LeastCoins();
        System.out.println(l.leastCoins1(coins,target));
    }
}
