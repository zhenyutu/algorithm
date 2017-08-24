package cn.tzy.app.leetcode.stack;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-8-23.
 * @author tuzhenyu
 * leetcode_394
 */
public class DecodeString {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        String result = "";

        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c==']'){
                String target = "";
                while(!stack.isEmpty()&&stack.peek()!='['){
                    target = stack.pop()+target;
                }
                stack.pop();
                String num = "";
                while (!stack.isEmpty()&&stack.peek()>='0'&&stack.peek()<='9'){
                    num = stack.pop() + num;
                }

                for (int j=0;j<Integer.parseInt(num);j++){
                    for (int k=0;k<target.length();k++){
                        stack.push(target.charAt(k));
                    }
                }
            }else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()){
            result = stack.pop()+result;
        }
        return result;
    }

    public static void main(String[] args) {
//        String str = "3[a]2[bc]";
        String str = "3[a2[c]]";
        DecodeString d = new DecodeString();
        System.out.println(d.decodeString(str));
    }
}
