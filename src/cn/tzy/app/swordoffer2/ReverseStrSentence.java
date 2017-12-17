package cn.tzy.app.swordoffer2;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-12-17.
 * @author tuzhenyu
 */
public class ReverseStrSentence {
    public String ReverseSentence(String str) {
        if (str==null||str.length()==0||str.trim().equals(""))
            return str;
        String[] strs = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i=strs.length-1;i>=0;i--){
            sb.append(strs[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public String ReverseSentence2(String str) {
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
}
