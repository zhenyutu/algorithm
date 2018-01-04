package cn.tzy.app.coderInterviewGuide2.chapter4;

/**
 * Created by tuzhenyu on 18-1-4.
 * @author tuzhenyu
 */
public class LeastCoinsOnlyOne {
    /**
     * 经典动态规划
     * @param coins
     * @param target
     * @return
     */
    public int minCoins(int[] coins,int target){
        if (coins==null||coins.length==0||target<0)
            return -1;
        int[][] dp = new int[coins.length][target+1];
        for (int j=1;j<=target;j++){
            dp[0][j] = Integer.MAX_VALUE;
        }
        if (coins[0]<=target){
            dp[0][coins[0]] = 1;
        }

        for (int i=1;i<coins.length;i++){
            for (int j=1;j<=target;j++){
                int leftup = Integer.MAX_VALUE;
                if (j>=coins[i]&&dp[i-1][j-coins[i]]!=Integer.MAX_VALUE){
                    leftup = dp[i-1][j-coins[i]] +1;
                }
                dp[i][j] = Math.min(leftup,dp[i-1][j]);
            }
        }

        return dp[coins.length-1][target]!=Integer.MAX_VALUE?dp[coins.length-1][target]:-1;
    }

    public static void main(String[] args) {
        LeastCoinsOnlyOne lo =new LeastCoinsOnlyOne();
        System.out.println(lo.minCoins(new int[]{5,5,5,10},15));
    }
}
