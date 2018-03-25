package cn.tzy.app.xiaozhao2018.leetcode;

import java.util.Stack;

/**
 * Created by tuzhenyu on 18-3-25.
 * @author tuzhenyu
 */
public class EvalRPN {
    public int getResult(String[] tokens){
        if (tokens==null||tokens.length==0)
            return -1;
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
                    default:
                        break;
                }
            }else{
                stack.push(Integer.parseInt(str));
            }
        }

        return stack.pop();
    }
}
