package cn.tzy.app.xiaozhao2018.swordoffer;

/**
 * Created by tuzhenyu on 18-3-19.
 * @author tuzhenyu
 */
public class StringMatcher {
    public boolean match(String str,String pattern){
        if (str==null||pattern==null)
            return false;

        return matchCore(str,0,pattern,0);
    }

    private boolean matchCore(String str,int strIndex,String pattern,int patIndex){
        if (patIndex==pattern.length()&&str.length()==strIndex)
            return true;
        if (patIndex!=pattern.length()&&strIndex==str.length())
            return false;

        char[] strs = str.toCharArray();
        char[] patterns = pattern.toCharArray();
        if (patIndex+1<pattern.length()&&patterns[patIndex+1]=='*'){
            if (strIndex!=str.length()&&patterns[patIndex]==strs[strIndex]
                    ||strIndex!=str.length()&&patterns[patIndex]=='.'){
                return matchCore(str,strIndex,pattern,patIndex+2)||
                        matchCore(str,strIndex+1,pattern,patIndex+2)||
                        matchCore(str,strIndex,pattern,patIndex);
            }
        }

        if (patterns[patIndex]=='.'||patterns[patIndex]==strs[strIndex])
            return matchCore(str,strIndex+1,pattern,patIndex+1);

        return false;
    }
}
