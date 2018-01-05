package cn.tzy.app.coderInterviewGuide.chapter4;

/**
 * Created by tuzhenyu on 18-1-5.
 * @author tuzhenyu
 */
public class SameSubStr {
    private int sameSubStr(String str1,String str2){
        if (str1==null||str2==null||str1.length()==0||str2.length()==0)
            return 0;
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int[][] dp = new int[str1.length()][str2.length()];
        dp[0][0] = chars1[0]==chars2[0]?1:0;
        for (int i=1;i<chars1.length;i++){
            if (chars1[i]==chars2[0])
                dp[i][0]=1;
        }

        for (int j=1;j<chars2.length;j++){
            if (chars2[j]==chars1[0])
                dp[0][j] = 1;
        }

        for (int i=1;i<chars1.length;i++){
            for (int j=1;j<chars2.length;j++){
                if (chars1[i]==chars2[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
            }
        }

        return dp[chars1.length-1][chars2.length-1];
    }
}
