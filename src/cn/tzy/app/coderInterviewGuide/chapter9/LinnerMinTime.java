package cn.tzy.app.coderInterviewGuide.chapter9;

/**
 * Created by tuzhenyu on 18-1-22.
 * @author tuzhenyu
 */
public class LinnerMinTime {
    public int getMinTime(int[] arr,int num){
        if (arr==null||arr.length==0||num<1)
            return -1;
        int[][] dp = new int[num][arr.length];
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for (int i=0;i<num;i++){
            dp[i][0] = arr[0];
        }
        for (int j=1;j<arr.length;j++){
            dp[0][j] = dp[0][j-1] + arr[j];
            sum[j] = sum[j-1] + arr[j];
        }

        for (int i=1;i<num;i++){
            for (int j=1;j<arr.length;j++){
                dp[i][j] = Integer.MAX_VALUE;
                for (int k=i;k<j;k++){
                    int cur = Math.max(dp[i-1][k],sum[j]-sum[k]);
                    dp[i][j] = Math.min(cur,dp[i][j]);
                }
            }
        }

        return dp[num-1][arr.length-1];
    }

    public static void main(String[] args) {
        LinnerMinTime l = new LinnerMinTime();
//        System.out.println(l.getMinTime(new int[]{1,1,1,4,3},3));
        System.out.println(l.getMinTime(new int[]{3,1,4},2));
    }
}
