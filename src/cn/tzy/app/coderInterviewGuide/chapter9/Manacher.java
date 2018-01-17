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

    /**
     * 马拉车算法　主要解决字符串的最长回文子串
     * @param str
     * @return
     */
    public int getMaxManacher(String str){
        if (str==null||str.length()==0)
            return -1;
        StringBuffer sb = new StringBuffer();
        sb.append("#");
        for (char c : str.toCharArray()){
            sb.append(c);
            sb.append("#");
        }
        char[] chars = sb.toString().toCharArray();
        int maxRight = 0;
        int pos = 0;
        int maxLen = 0;
        int[] res = new int[chars.length];
        for (int i=0;i<chars.length;i++){
            if (i<maxRight){
                res[i] = Math.min(res[2*pos-i],maxRight-i);
            }else
                res[i] = 1;
            while (i-res[i]>=0&&i+res[i]<chars.length&&chars[i-res[i]]==chars[i+res[i]]){
                res[i]++;
            }

            if (i+res[i]-1>maxRight){
                maxRight = i+res[i]-1;
                pos = i;
            }

            maxLen = Math.max(maxLen,res[i]);
        }

        return maxLen-1;
    }


    public static void main(String[] args) {
        Manacher m = new Manacher();
        System.out.println(m.getMax("abc1234321cba"));
        System.out.println(m.getMaxManacher("abc1234321cba"));
    }
}


