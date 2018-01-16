package cn.tzy.app.coderInterviewGuide.chapter9;

/**
 * Created by tuzhenyu on 18-1-16.
 * @author tuzhenyu
 */
public class Manacher {
    public int getMax(String str){
        if (str==null||str.length()==0)
            return 0;
        char[] chars = str.toCharArray();
        int[][] dp = new int[str.length()][str.length()];
        for (int i=0;i<str.length();i++){
            dp[i][i] = 1;
        }
        int max = Integer.MIN_VALUE;
        for (int i=1;i<str.length();i++){
            for (int j=i-1;j>=0;j--){
                if (chars[i]==chars[j]){
                    dp[j][i] = dp[j+1][i-1]+2;
                }
                max = Math.max(max,dp[j][i]);
            }
        }

        return max;
    }

    

    public static void main(String[] args) {
        Manacher m = new Manacher();
        System.out.println(m.getMax("abc1234321cba"));
    }
}


