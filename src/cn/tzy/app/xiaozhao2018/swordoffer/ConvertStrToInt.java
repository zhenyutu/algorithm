package cn.tzy.app.xiaozhao2018.swordoffer;

/**
 * Created by tuzhenyu on 18-3-18.
 * @author tuzhenyu
 */
public class ConvertStrToInt {
    public int convert(String str){
        if (str==null||str.length()==0)
            return 0;
        char[] chars = str.toCharArray();
        int res = 0;
        boolean flag = false;
        if (isValid(chars)){
            int start = 0;
            if (chars[0]=='-'||chars[0]=='+'){
                start=1;
                flag = chars[0]=='-';
            }
            for (int i=start;i<chars.length;i++){
                res = res*10+(chars[i]-'0');
            }
        }

        return flag?-res:res;
    }

    private boolean isValid(char[] chars){
        int start = 0;
        if (chars[0]=='-'||chars[0]=='+'){
            start=1;
        }

        if ((chars[0]=='-'||chars[0]=='+')&&chars.length==1)
            return false;

        for (int i=start;i<chars.length;i++){
            if (chars[i]<'0'||chars[i]>'9')
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ConvertStrToInt c = new ConvertStrToInt();
        System.out.println(c.convert("-123a45"));
    }
}
