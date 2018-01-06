package cn.tzy.app.xiaozhao2017;

/**
 * Created by tuzhenyu on 18-1-6.
 * @author tuzhenyu
 */
public class MaxSongAbilityMulti {
    public int getMax(int[] ab,int k){
        if (ab==null||ab.length==0||k<0)
            return -1;
        int n = ab.length;
        int[][] dp = new int[k][n];
        for (int j=0;j<n;j++){
            dp[0][j] = ab[j];
        }
        for (int i=1;i<k;i++){
            for (int j=i;j<n;j++){
                for (int x=j-1;x>=0&&j-x<=50;x--){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][x]*ab[j]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int p=0;p<n;p++){
            max = Math.max(max,dp[k-1][p]);
        }

        return max;
    }

    public int getMax2(int[] ab,int k){
        if (ab==null||ab.length==0||k<0)
            return -1;
        int n = ab.length;
        int[][] dp = new int[k][n];
        dp[0][0]=ab[0];
        for (int j=1;j<n;j++){
            dp[0][j] = ab[j];
        }
        for (int i=1;i<k;i++){
            for (int j=i;j<n;j++){
                dp[i][j] = Math.max(dp[i-1][j-1]*ab[j],dp[i][j-1]);
            }
        }

        return dp[k-1][n-1];
    }

    public static void main(String[] args) {
        MaxSongAbilityMulti m = new MaxSongAbilityMulti();
        System.out.println(m.getMax(new int[]{7,4,7,2},2));
    }
}
