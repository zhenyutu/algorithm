package cn.tzy.app.coderInterviewGuide.chapter4;

/**
 * Created by tuzhenyu on 18-1-4.
 * @author tuzhenyu
 */
public class SameSubSeq {
    public int sameSubSeq(String str1,String str2){
        if (str1==null||str2==null||str1.length()==0||str2.length()==0)
            return -1;

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int[][] dp = new int[chars1.length][chars2.length];
        if (chars1[0]==chars2[0])
            dp[0][0]=1;
        for (int i=1;i<chars1.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],chars1[i]==chars2[0]?1:0);
        }
        for (int j=1;j<chars2.length;j++){
            dp[0][j] = Math.max(dp[0][j-1],chars2[j]==chars1[0]?1:0);
        }

        for (int i=1;i<chars1.length;i++){
            for (int j=1;j<chars2.length;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if (chars1[i]==chars2[j]){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+1);
                }
            }
        }

        return dp[chars1.length-1][chars2.length-1];
    }
}
