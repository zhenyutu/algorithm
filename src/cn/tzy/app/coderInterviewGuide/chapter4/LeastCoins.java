package cn.tzy.app.coderInterviewGuide.chapter4;

import java.util.Arrays;

/**
 * Created by tuzhenyu on 17-9-17.
 * @author tuzhenyu
 */
public class LeastCoins {
    public static int getLeastCoins(int[] coins,int money){
        int[] dp = new int[money+1];
        for (int k=0;k<=money;k++){
            dp[k] = k;
        }
        for (int i=0;i<=money;i++){
            for (int j=0;j<coins.length;j++){
                if (i>=coins[j]&&dp[i-coins[j]]+1<dp[i]){
                    dp[i] = dp[i-coins[j]]+1;
                }
            }
        }
        return dp[money];
    }

    public static void main(String[] args) {
        int[] coins = {1,3,5};
        int money = 11;
        System.out.println(getLeastCoins(coins,money));
    }
}
