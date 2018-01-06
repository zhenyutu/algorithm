package cn.tzy.app.xiaozhao2017;

import java.util.Set;

/**
 * Created by tuzhenyu on 18-1-6.
 * @author tuzhenyu
 */
public class WordBreak{
    public boolean wordBreak(String s, Set<String> dict){
        if (s==null||s.length()==0||dict==null||dict.size()==0)
            return false;
        boolean[] dp = new boolean[s.length()];
        dp[0]=true;
        for (int i=1;i<=s.length();i++){
            for (int j=0;j<i;j++){
                if (dp[j]&&dict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()-1];
    }
}
