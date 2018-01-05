package cn.tzy.app.coderInterviewGuide2.chapter4;

/**
 * Created by tuzhenyu on 18-1-5.
 * @author tuzhenyu
 */
public class EditMinCost {
    public int minCost(String str1,String str2){
        if (str1==null||str2==null||str1.length()==0||str2.length()==0)
            return -1;
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int[][] dp = new int[chars1.length+1][chars2.length+1];
        dp[0][0] = 0;
        for (int i=1;i<=chars1.length;i++){
            dp[i][0] = 3*i;
        }
        for (int j=1;j<=chars2.length;j++){
            dp[0][j] = 5*j;
        }

        for (int i=1;i<=chars1.length;i++){
            for (int j=1;j<=chars2.length;j++){
                if (chars1[i]==chars2[j])
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = dp[i-1][j-1]+2;

                dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+5);
                dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+3);
            }
        }

        return dp[chars1.length][chars2.length];
    }
}
