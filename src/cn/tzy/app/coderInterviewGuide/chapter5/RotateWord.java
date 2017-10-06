package cn.tzy.app.coderInterviewGuide.chapter5;

/**
 * Created by tuzhenyu on 17-10-6.
 * @author tuzhenyu
 */
public class RotateWord {
    public String rotate(String str,int size){
        if (str==null||str.length()==0)
            return str;
        char[] chars = str.toCharArray();
        reverse(chars,0,size-1);
        reverse(chars,size,chars.length-1);
        reverse(chars,0,chars.length-1);
        return new String(chars);
    }

    private void reverse(char[] chars,int start,int end){
        for (;start<=end;start++,end--){
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
        }
    }

    public static void main(String[] args) {
        RotateWord r = new RotateWord();
        System.out.println(r.rotate("ABCDE",3));
    }
}
