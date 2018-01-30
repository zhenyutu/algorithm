package cn.tzy.app.leetcode.niuke;

import java.util.Stack;

/**
 * Created by tuzhenyu on 18-1-30.
 * @author tuzhenyu
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        if (tokens==null||tokens.length==0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens){
            if ("+".equals(str)||"-".equals(str)||"*".equals(str)||"/".equals(str)){
                int x = stack.pop();
                int y = stack.pop();
                switch (str){
                    case "+":
                        stack.push(x+y);
                        break;
                    case "-":
                        stack.push(y-x);
                        break;
                    case "*":
                        stack.push(x*y);
                        break;
                    case "/":
                        stack.push(y/x);
                        break;

                }
            }else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvalRPN e = new EvalRPN();
        System.out.println(e.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(e.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
