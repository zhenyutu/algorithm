package cn.tzy.app.coderInterviewGuide.chapter5;

/**
 * Created by tuzhenyu on 17-10-3.
 * @author tuzhenyu
 */
public class MoveStr {
    public String move(String str){
        if (str==null||str.length()==0)
            return str;
        char[] chars = str.toCharArray();
        int pre=0;
        int post=0;
        while (pre<chars.length){
            if (chars[pre]!='*'&&chars[post]=='*'){
                chars[post] = chars[pre];
                chars[pre] = '*';
            }

            pre++;
            if (chars[post]!='*'){
                post++;
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        MoveStr m = new MoveStr();
        System.out.println(m.move("12****345"));
    }
}
