package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-25.
 * @author tuzhenyu
 */
public class StringPattenMatch {
    public boolean match(char[] str, char[] pattern)
    {
        if (str==null||pattern==null)
            return false;
        int strIndex = 0;
        int patIndex = 0;
        return matchCore(str,strIndex,pattern,patIndex);
    }

    private boolean matchCore(char[] str,int strIndex,char[] pattern,int patIndex){
        if (strIndex==str.length&&patIndex==pattern.length)
            return true;
        if (strIndex!=str.length&&patIndex==pattern.length)
            return false;

        if (patIndex+1<pattern.length&&pattern[patIndex+1]=='*'){
            if ((strIndex!=str.length&&str[strIndex]==pattern[patIndex])||(pattern[patIndex] == '.' && strIndex != str.length)){
                return (matchCore(str,strIndex,pattern,patIndex+2)||
                matchCore(str,strIndex+1,pattern,patIndex+2)||
                matchCore(str,strIndex+1,pattern,patIndex));
            }else {
                return matchCore(str,strIndex,pattern,patIndex+2);
            }
        }

        if ((pattern[patIndex]=='.'&&strIndex!=str.length)||(strIndex!=str.length&&str[strIndex]==pattern[patIndex]))
            return matchCore(str,strIndex+1,pattern,patIndex+1);

        return false;
    }
}
