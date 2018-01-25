package cn.tzy.app.xiaozhao2017;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ab = new int[n];
        for (int i=0;i<n;i++){
            ab[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int d = scanner.nextInt();

        int[][] maxMulti = new int[k][n];
        int[][] minMulti = new int[k][n];
        maxMulti[0][0] = ab[0];
        minMulti[0][0] = ab[0];
        for (int i=1;i<n;i++){
            maxMulti[0][i] = Math.max(maxMulti[0][i-1],ab[i]);
            minMulti[0][i] = Math.min(minMulti[0][i-1],ab[i]);
        }

        long res = ab[0];
        for (int i=1;i<k;i++){
            for (int j=i;j<n;j++){
                for (int x=j-1;x>=0&&j-x<=d;x--){
                    maxMulti[i][j] = Math.max(maxMulti[i][j], Math.max(maxMulti[i - 1][x] * ab[j],minMulti[i - 1][x] * ab[j]));
                    minMulti[i][j] = Math.min(minMulti[i][j], Math.min(maxMulti[i - 1][x] * ab[j],minMulti[i - 1][x] * ab[j]));
                }
                res = Math.max(res,maxMulti[i][j]);
            }
        }
        System.out.println(res);
    }
}
