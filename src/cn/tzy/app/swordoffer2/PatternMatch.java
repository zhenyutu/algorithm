package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-19.
 * @author tuzhenyu
 */
public class PatternMatch {
    public boolean match(char[] str, char[] pattern){
        if (str==null||pattern==null)
            return false;
        int patIndx = 0;
        int strIndx = 0;
        return matchCore(str,strIndx,pattern,patIndx);
    }

    private boolean matchCore(char[] str,int strIndx,char[] pattern,int patIndx){
        if (strIndx==str.length&&patIndx==pattern.length)
            return true;
        if (strIndx!=str.length&&patIndx==pattern.length)
            return false;

        if ((strIndx!=str.length&&str[strIndx]==pattern[patIndx])||(strIndx!=str.length&&'.'==pattern[patIndx]))
            return matchCore(str,strIndx+1,pattern,patIndx+1);

        if (patIndx+1<pattern.length&&pattern[patIndx+1]=='*'){
            if ((strIndx!=str.length&&pattern[patIndx]==str[strIndx])||(strIndx!=str.length&&pattern[patIndx]=='.')){
                return (matchCore(str,strIndx,pattern,patIndx+2)&&matchCore(str,strIndx+1,pattern,patIndx+1)&&
                        (matchCore(str,strIndx+1,pattern,patIndx+2)));
            }else
                return matchCore(str,strIndx,pattern,patIndx+2);
        }

        return false;
    }
}
