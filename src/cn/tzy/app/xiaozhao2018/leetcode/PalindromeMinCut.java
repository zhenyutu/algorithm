package cn.tzy.app.xiaozhao2018.leetcode;

/**
 * Created by tuzhenyu on 18-4-14.
 * @author tuzhenyu
 */
public class PalindromeMinCut {
    public int minCut(String s) {
        if (s==null||s.length()==0)
            return -1;
        char[] chars = s.toCharArray();
        boolean[][] state = new boolean[s.length()][s.length()];
        int[] dp = new int[s.length()];

        for (int i=0;i<s.length();i++){
            state[i][i] = true;
        }

        dp[0] = 0;
        for (int i=1;i<s.length();i++){
            dp[i] = dp[i-1]+1;
            for (int j=i-1;j>=0;j--){
                if (chars[i]==chars[j]&&(i-j<2||state[j+1][i-1])){
                    state[j][i] = true;
                    if (j>0)
                        dp[i] = Math.min(dp[i],dp[j-1]+1);
                    else
                        dp[i] = Math.min(dp[i],0);
                }
            }
        }

        return dp[s.length()-1];
    }

    public static void main(String[] args) {
        PalindromeMinCut p = new PalindromeMinCut();
        System.out.println(p.minCut("cbbbcc"));
    }
}
