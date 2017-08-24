package cn.tzy.app.leetcode.stack;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-8-24.
 * @author tuzhenyu
 * leetcode_150
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int op1,op2;
        for (String str : tokens){
            if ("+".equals(str)||"-".equals(str)||"*".equals(str)||"/".equals(str)){
                op2 = Integer.parseInt(stack.pop());
                op1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(operate(op1,op2,str)));
            }else{
                stack.push(str);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private int operate(int op1,int op2,String operator){
        if ("+".equals(operator))
            return op1+op2;
        else if ("-".equals(operator))
            return op1-op2;
        else if ("*".equals(operator))
            return op1*op2;
        else
            return op1/op2;
    }

    public static void main(String[] args) {
//        String[] strs = {"2", "1", "+", "3", "*"};
        String[] strs = {"4", "13", "5", "/", "+"};
        EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
        System.out.println(e.evalRPN(strs));
    }
}
