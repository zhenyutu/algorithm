package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-22.
 * @author tuzhenyu
 */
public class StringLeftRotate {
    public String LeftRotateString(String str,int n) {
        if (str==null||n<0)
            return null;
        if (str.length()==0)
            return str;
        int num = n%str.length();
        StringBuffer sb = new StringBuffer();
        sb.append(str.substring(num,str.length()));
        sb.append(str.substring(0,num));
        return sb.toString();
    }

    public String LeftRotateString2(String str,int n) {
        if (str==null||n<0)
            return null;
        if (str.length()==0)
            return str;
        int num = n%str.length();
        String s = str+str;
        return s.substring(num,num+str.length());
    }

    public static void main(String[] args) {
        StringLeftRotate s = new StringLeftRotate();
        System.out.println(s.LeftRotateString2("abc",10));
    }
}
