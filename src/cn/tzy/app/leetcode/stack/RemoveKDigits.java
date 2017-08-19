package cn.tzy.app.leetcode.stack;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-8-19.
 * @author tuzhenyu
 * leetcode_402
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        String result = "";
        for (int i=0;i<num.length();i++){
            char c = num.charAt(i);
            while (k>0&&!stack.isEmpty()&&stack.peek()>c){
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while (k>0){
            stack.pop();
            k--;
        }

        while (!stack.isEmpty()){
            result = stack.pop()+result;
        }

        while (result.length()>1&& result.charAt(0)=='0')
            result = result.substring(1,result.length());

        return "".equals(result)?"0":result;
    }

    public static void main(String[] args) {
        String num = "1432219";
        RemoveKDigits r = new RemoveKDigits();
        System.out.println(r.removeKdigits(num,3));
    }
}
