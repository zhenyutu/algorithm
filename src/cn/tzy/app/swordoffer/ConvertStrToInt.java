package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-24.
 * @author tuzhenyu
 */
public class ConvertStrToInt {
    public int StrToInt(String str) {
        if (str==null||str.length()==0)
            return 0;
        char[] chars = str.toCharArray();
        int posi = 0,res = 0;
        boolean flag = true;
        if (isValid(chars)){
            if (chars[0]=='-'){
                posi = 1;
                flag = false;
            }else if (chars[0]=='+')
                posi = 1;
            else
                posi = 0;

            String string = str.substring(posi,str.length());
            if (flag&&String.valueOf(Integer.MAX_VALUE).compareTo(string)<0)
                return 0;
            if (!flag&&String.valueOf(Integer.MIN_VALUE).compareTo(string)>0)
                return 0;
            for (int i= posi;i<chars.length;i++){
                int cur = chars[i]-'0';
                res = res*10 + cur;
            }

            return flag?res:-res;

        }

        return 0;

    }

    private boolean isValid(char[] chars){
        if (chars[0]!='-'&&chars[0]!='+'&&(chars[0]<='0'||chars[0]>'9'))
            return false;
        if ((chars[0]=='-'||chars[0]=='+')&&chars.length==1)
            return false;
        for (int i=1;i<chars.length;i++){
            if (chars[i]>'9'||chars[i]<'0')
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ConvertStrToInt c = new ConvertStrToInt();
        System.out.println(c.StrToInt("-2147483648"));
    }
}
