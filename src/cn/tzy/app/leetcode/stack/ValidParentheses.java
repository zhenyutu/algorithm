package cn.tzy.app.leetcode.stack;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-8-16.
 * @author tuzhenyu
 * leetcode_20
 */
public class ValidParentheses {
    private Stack<Character> stack = new Stack<>();

    public boolean isValid(String s) {
        for (int i = 0;i<s.length();i++){
            char left = s.charAt(i);
            if (left=='['||left=='{'||left=='(')
                stack.push(left);
            else{
                if (stack.isEmpty())
                    return false;
                char right = stack.pop();
                if (left=='}'&&right!='{')
                    return false;
                if (left==')'&&right!='(')
                    return false;
                if (left==']'&&right!='[')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "[{}]";
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid(str));
    }
}
