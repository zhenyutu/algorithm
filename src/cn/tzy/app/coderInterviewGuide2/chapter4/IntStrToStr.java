package cn.tzy.app.coderInterviewGuide2.chapter4;

/**
 * Created by tuzhenyu on 18-1-7.
 * @author tuzhenyu
 */
public class IntStrToStr {
    public int convert(String str){
        if (str==null||str.length()==0)
            return 0;
        char[] chars = str.toCharArray();
        int[] dp = new int[str.length()+1];
        dp[0]=1;
        dp[1]=1;
        if (chars[0]=='0')
            return 0;
        for (int i=2;i<=str.length();i++){
            if (chars[i-2]!='0'&&Integer.parseInt(str.substring(i-2,i))<26)
                dp[i] = dp[i-1]+dp[i-2];
            else
                dp[i] = dp[i-1];
        }
        return dp[str.length()];
    }

    public int convert2(String str){
        if (str==null||str.length()==0)
            return 0;
        char[] chars = str.toCharArray();
        return process(chars,0);
    }
    private int process(char[] chars,int index){
        if (chars.length==index)
            return 1;
        if (chars[index]==0)
            return 0;
        int res = process(chars,index+1);
        if (index+1<chars.length&&(chars[index]-'0')*10+chars[index+1]-'0'<27)
            res += process(chars,index+2);
        return res;
    }

    public static void main(String[] args) {
        IntStrToStr i = new IntStrToStr();
        System.out.println(i.convert("1111"));
    }
}
