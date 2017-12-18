package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-18.
 * @author tuzhenyu
 */
public class ConvertStrToInt {
    public int StrToInt(String str) {
        if (str==null||str.length()==0)
            return 0;
        int pos = 0;
        boolean flag = true;
        char[] chars = str.toCharArray();
        if (isValid(str)){
            if (chars[0]=='-'){
                flag = false;
                pos = 1;
            }else if (chars[0]=='+'){
                flag = true;
                pos = 1;
            }
            str = str.substring(pos);
            if (flag&&String.valueOf(Integer.MAX_VALUE).compareTo(str)<0)
                return 0;
            if (!flag&&String.valueOf(Integer.MIN_VALUE).compareTo(str)<0)
                return 0;

            int sum = 0;
            for (int i=pos;i<chars.length;i++){
                sum = sum*10 + (chars[i]-'0');
            }

            return flag?sum:-sum;
        }

        return 0;
    }

    private boolean isValid(String str){
        char[] chars = str.toCharArray();
        if (chars[0]!='-'&&chars[0]!='+'&&(chars[0]<'0'||chars[0]>'9'))
            return false;
        if ((chars[0]=='-'||chars[0]=='+')&&chars.length==1)
            return false;
        for (int i=1;i<chars.length;i++){
            if (chars[i]<'0'||chars[0]>'9')
                return false;
        }
        return true;
    }
}
