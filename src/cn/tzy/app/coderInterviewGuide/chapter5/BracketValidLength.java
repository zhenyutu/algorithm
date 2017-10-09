package cn.tzy.app.coderInterviewGuide.chapter5;

/**
 * Created by tuzhenyu on 17-10-8.
 * @author tuzhenyu
 */
public class BracketValidLength {
    public boolean isValid(String str){
        if (str==null||str.length()==0)
            return false;
        char[] chars = str.toCharArray();
        int status = 0;
        for (int i=0;i<chars.length;i++){
            if (chars[i]!='('&&chars[i]!=')')
                return false;
            else if (chars[i]=='(')
                status++;
            else if (chars[i]==')'&&--status<0)
                return false;
        }
        return status==0;
    }

    public int maxLen(String str){
        if (str==null||str.length()==0)
            return 0;
        int[] dp = new int[str.length()];
        int max = 0;
        int pre = 0;
        char[] chars = str.toCharArray();
        for (int i=1;i<chars.length;i++){
            if (chars[i]==')'){
                pre = i-1-dp[i-1];
                if (pre>=0&&chars[pre]=='('){
                    dp[i] = dp[i-1]+2+(pre>0?dp[pre-1]:0);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        BracketValidLength b = new BracketValidLength();
        System.out.println(b.maxLen("(())()("));
    }
}
