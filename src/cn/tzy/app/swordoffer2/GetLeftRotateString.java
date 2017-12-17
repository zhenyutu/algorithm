package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-17.
 * @author tuzhenyu
 */
public class GetLeftRotateString {
    public String LeftRotateString(String str,int n) {
        if (str==null||n<0)
            return null;
        if (str.length()==0)
            return str;
        if (n>str.length())
            n = n%str.length();
        String s = str + str;
        return s.substring(n,n+str.length());
    }
}
