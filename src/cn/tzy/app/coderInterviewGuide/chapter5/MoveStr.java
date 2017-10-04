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

    public String move2(String str){
        if (str==null||str.length()==0)
            return str;
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i=0;i<chars.length;i++){
            if (chars[i]!='*'){
                if (count!=i){
                    chars[count] = chars[i];
                }
                count++;
            }
        }
        for (int j=count;j<chars.length;j++){
            chars[j] = '*';
        }

        return new String(chars);
    }

    public String move3(String str){
        if (str==null||str.length()==0)
            return str;
        char[] chars = str.toCharArray();
        int count = chars.length-1;
        for (int i=chars.length-1;i>=0;i--){
            if (chars[i]!='*'){
                if (i!=count){
                    chars[count] = chars[i];
                }
                count--;
            }
        }
        for (int j=0;j<count;j++){
            chars[j] = '*';
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        MoveStr m = new MoveStr();
        System.out.println(m.move3("12*****345"));
    }
}
