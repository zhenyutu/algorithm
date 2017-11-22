package cn.tzy.app.swordoffer;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-11-22.
 * @author tuzhenyu
 */
public class SentenceReverse {
    public String ReverseSentence(String str) {
        if (str==null||str.length()==0||str.trim().equals(""))
            return str;
        Stack<String> stack = new Stack<>();
        String[] strs = str.split(" ");
        for (int i=0;i<strs.length;i++){
            stack.push(strs[i]);
        }
        StringBuffer sb = new StringBuffer();
        sb.append(stack.pop());
        while (!stack.isEmpty()){
            sb.append(" ");
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SentenceReverse s = new SentenceReverse();
        System.out.println(s.ReverseSentence(" "));
    }
}
