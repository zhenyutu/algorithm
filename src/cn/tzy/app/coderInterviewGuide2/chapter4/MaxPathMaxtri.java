package cn.tzy.app.coderInterviewGuide2.chapter4;

/**
 * Created by tuzhenyu on 18-1-7.
 * @author tuzhenyu
 */
public class MaxPathMaxtri {
    public int getMaxPath(int[][] arr){
        if (arr==null||arr.length==0||arr[0].length==0)
            return -1;
        int[][] dp = new int[arr.length][arr[0].length];
        dp[0][0] = arr[0][0];
        for (int i=1;i<arr.length;i++){
            dp[i][0] = Math.min(dp[i-1][0]+arr[i][0],dp[i-1][0]);
        }
        for (int j=1;j<arr[0].length;j++){
            dp[0][j] = Math.min(dp[0][j-1] + arr[0][j],dp[0][j-1]);
        }
        for (int i=1;i<arr.length;i++){
            for (int j=1;j<arr[0].length;j++){
                if (arr[i][j]<0)
                    dp[i][j] = Math.max(dp[i-1][j]+arr[i][j],dp[i][j-1]+arr[i][j]);
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return -dp[arr.length-1][arr[0].length-1]+1;
    }

    public static void main(String[] args) {
        MaxPathMaxtri m = new MaxPathMaxtri();
        System.out.println(m.getMaxPath(new int[][]{{-2,-3,3},{-5,-10,1},{0,30,-5}}));
    }
}
