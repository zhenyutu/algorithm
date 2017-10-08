package cn.tzy.app.coderInterviewGuide.chapter5;

/**
 * Created by tuzhenyu on 17-10-8.
 * @author tuzhenyu
 */
public class BracketValidLength {
    public boolean isValid(String str){
        if (str==null||str.length()==0)
            return false;
        char[] chars = str.toCharArray();
        int status = 0;
        for (int i=0;i<chars.length;i++){
            if (chars[i]!='('&&chars[i]!=')')
                return false;
            else if (chars[i]=='(')
                status++;
            else if (chars[i]==')'&&--status<0)
                return false;
        }
        return status==0;
    }

    public static void main(String[] args) {
        BracketValidLength b = new BracketValidLength();
        System.out.println(b.isValid("()()("));
    }
}
