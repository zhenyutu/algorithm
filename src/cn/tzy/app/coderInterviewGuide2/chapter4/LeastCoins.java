package cn.tzy.app.coderInterviewGuide2.chapter4;

/**
 * Created by tuzhenyu on 18-1-4.
 * @author tuzhenyu
 */
public class LeastCoins {
    /**
     * 优化后的动态规划
     * @param coins
     * @param target
     * @return
     */
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

    /**
     * 经典动态规划
     * @param coins
     * @param target
     * @return
     */
    public int leastCoins2(int[] coins,int target){
        if (coins==null||coins.length==0||target<0)
            return -1;
        int[][] dp = new int[coins.length][target+1];
        for (int j=1;j<target+1;j++){
            dp[0][j] = Integer.MAX_VALUE;
            if (j-coins[0]>=0&&dp[0][j-coins[0]]!=Integer.MAX_VALUE){
                dp[0][j] = dp[0][j-coins[0]]+1;
            }
        }
        for (int i=1;i<coins.length;i++){
            for (int j=0;j<=target;j++){
                int left = Integer.MAX_VALUE;
                if (j>=coins[i]&&dp[i][j-coins[i]]!=Integer.MAX_VALUE){
                    left = dp[i][j-coins[i]]+1;
                }
                dp[i][j] = Math.min(left,dp[i-1][j]);
            }
        }

        return dp[coins.length-1][target] !=Integer.MAX_VALUE?dp[coins.length-1][target]:-1;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,3,5};
        int target = 15;
        LeastCoins l = new LeastCoins();
        System.out.println(l.leastCoins2(coins,target));
    }
}
