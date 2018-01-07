package cn.tzy.app.coderInterviewGuide2.chapter4;

/**
 * Created by tuzhenyu on 18-1-7.
 * @author tuzhenyu
 */
public class StrsCross {
    public boolean isCross(String str1,String str2,String aim){
        if (str1==null||str1.length()==0||
                str2==null||str2.length()==0||aim==null||aim.length()==0)
            return false;
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        char[] chaim = aim.toCharArray();

        boolean[][] dp = new boolean[str1.length()+1][str2.length()+1];
        for (int i=1;i<=str1.length();i++){
            if (chars1[i-1]!=chaim[i-1]){
                break;
            }
            dp[i][0] = true;
        }

        for (int j=1;j<=str2.length();j++){
            if (chars2[j-1]!=chaim[j-1])
                break;
            dp[0][j] = true;
        }

        for (int i=1;i<=str1.length();i++){
            for (int j=1;j<=str2.length();j++){
                if ((chars1[i-1]==chaim[i+j-1]&&dp[i][j-1])||
                        chars2[j-1]==chaim[i+j-1]&&dp[i-1][j])
                    dp[i][j] = true;
            }
        }

        return dp[str1.length()][str2.length()];
    }
}
