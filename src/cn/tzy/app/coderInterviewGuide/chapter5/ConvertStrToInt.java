package cn.tzy.app.coderInterviewGuide.chapter5;

/**
 * Created by tuzhenyu on 17-10-1.
 * @author tuzhenyu
 */
public class ConvertStrToInt {
    public int convert(String str){
        if (str==null||"".equals(str))
            return 0;
        int res = 0;
        char[] chars = str.toCharArray();
        if (isValid(chars)){
            if (String.valueOf(Integer.MAX_VALUE).compareTo(str)<0)
                return 0;
            int posi = chars[0]=='-'?1:0;
            for (int i=posi;i<chars.length;i++){
                int cur = chars[i]-'0';
                res = res*10+cur;
            }
            res = posi==0?res:-res;
        }

        return res;
    }

    private boolean isValid(char[] chars){
        if (chars[0]!='-'&&(chars[0]<='0'||chars[0]>'9'))
            return false;
        if (chars[0]=='-'&&(chars.length==1&&chars[1]=='0'))
            return false;
        for (int i=1;i<chars.length;i++){
            if (chars[i]>'9'||chars[i]<'0')
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ConvertStrToInt c = new ConvertStrToInt();
        System.out.println(c.convert("2147483647"));
    }
}
