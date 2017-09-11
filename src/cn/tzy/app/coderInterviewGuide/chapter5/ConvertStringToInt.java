package cn.tzy.app.coderInterviewGuide.chapter5;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-9-10.
 * @author tuzhenyu
 */
public class ConvertStringToInt {
    public int convert(String str){
        int res = 0;
        boolean neg = false;
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if (c=='-'){
                neg = !neg;
            }else if (c>='0'&&c<='9'){
                res = res*10 + (c-'0');
            }else {
                return 0;
            }
        }

        return neg==true?-res:res;
    }

    public static void main(String[] args) {
        ConvertStringToInt c = new ConvertStringToInt();
        String str = "123a";
        System.out.println(c.convert(str));

    }
}
