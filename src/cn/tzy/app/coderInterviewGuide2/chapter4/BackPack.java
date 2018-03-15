package cn.tzy.app.coderInterviewGuide2.chapter4;

/**
 * Created by tuzhenyu on 18-1-4.
 * @author tuzhenyu
 */
public class BackPack {
    /**
     * 背包问题　重量＋价值组合
     * @param m
     * @param a
     * @param v
     * @return
     */
    public int backPack(int m,int[] a,int[] v){
        if (m<0||a==null||v==null)
            return -1;
        int[][] val = new int[a.length][m+1];
        for (int j=1;j<=m;j++){
            if (j>=a[0]&&val[0][j-a[0]]!=0){
                val[0][j] = val[0][j-a[0]]+v[0];
            }
        }

        for (int i=1;i<a.length;i++){
            for (int j=1;j<=m;j++){
                if (j>a[i]&&val[i-1][j-a[i]]+v[i]>val[i-1][j]){
                    val[i][j] = val[i-1][j-a[i]]+v[i];
                }else {
                    val[i][j] = val[i-1][j];
                }
            }
        }

        return val[a.length-1][m];
    }

    public int maxValue(int target,int[] m,int[] v){
        if (target<0||m==null||v==null)
            return -1;
        int[][] dp = new int[m.length][target+1];
        for (int i=1;i<=target;i++){
            if (i>m[0]&&dp[0][i-m[0]]!=0){
                dp[0][i] = dp[0][i-m[0]]+v[0];
            }
        }
        for (int i=1;i<m.length;i++){
            for (int j=0;i<=target;j++){
                if (j>m[i]){
                    dp[i][j] = Math.max(dp[i-1][j-m[i]]+v[i],dp[i-1][j]);
                }
            }
        }

        return dp[m.length-1][target];
    }
}
