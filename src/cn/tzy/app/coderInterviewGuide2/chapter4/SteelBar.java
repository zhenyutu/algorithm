package cn.tzy.app.coderInterviewGuide2.chapter4;

/**
 * Created by tuzhenyu on 18-1-4.
 * @author tuzhenyu
 */
public class SteelBar {
    /**
     * 暴力递归
     * @param price
     * @param n
     * @return
     */
    public int maxPrice(int[] price,int n){
        if (price==null||n<0)
            return -1;
        return getMax(price,n);
    }

    private int getMax(int[] price,int n){
        if (n<0)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int i=1;i<=price.length&&i<=n;i++){
            max = Math.max(max,getMax(price,n-i)+price[i-1]);
        }
        return max;
    }

    /**
     * 动态规划
     * @param price
     * @param n
     * @return
     */
    public int maxPrice1(int[] price,int n){
        if (price==null||n<0)
            return -1;
        int[] dp = new int[n+1];
        for (int i=1;i<dp.length;i++){
            dp[i] = price[0]*i;
        }
        for (int i=1;i<=n;i++){
            for (int j=1;j<i;j++){
                if (dp[i]<dp[i-j]+price[j-1]){
                    dp[i] = dp[i-j]+price[j-1];
                }
            }
        }

        return dp[n];
    }
}
