package cn.tzy.app.coderInterviewGuide.chapter5;

import sun.misc.Cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by tuzhenyu on 17-10-9.
 * @author tuzhenyu
 */
public class CalculateNumStr {
    /**
     * 将表达式字符串转换成数字字符串数组
     * @param str
     * @return
     */
    public ArrayList<String> getStringList(String str){
        ArrayList<String> arrayList = new ArrayList<>();
        char[] chars = str.toCharArray();
        String num = "";
        for (int i=0;i<chars.length;i++){
            if (Character.isDigit(chars[i])){
                num += chars[i];
            }else {
                if (!"".equals(num))
                    arrayList.add(num);
                num = "";
                arrayList.add(chars[i]+"");
            }
        }
        if (!"".equals(num))
            arrayList.add(num);
        return arrayList;
    }

    private boolean isOperator(String op){
        if ("+".equals(op)||"-".equals(op)||"*".equals(op)||"/".equals(op)
                ||"(".equals(op)||")".equals(op))
            return true;
        return false;
    }

    private boolean compare(String peek,String cur){
        if ("*".equals(peek)&&("+".equals(cur)||"-".equals(cur)||"*".equals(cur)||"/".equals(cur)))
            return true;
        else if ("/".equals(peek)&&("+".equals(cur)||"-".equals(cur)||"*".equals(cur)||"/".equals(cur)))
            return true;
        else if ("+".equals(peek)&&("+".equals(cur)||"-".equals(cur)))
            return true;
        else if ("-".equals(peek)&&("+".equals(cur)||"-".equals(cur)))
            return true;
        return false;
    }

    /**
     * 构造操作符栈将，将表达式字符串列表转变成后缀表达式列表；
     * 从头遍历表达式列表，如果是数字则加入后缀表达式列表，如果是操作符则加入操作符栈；
     * 如果是操作符，并且当前操作符优先级高于栈顶操作符则直接将操作符入栈；
     * 如果是操作符，并且当前操作符优先级不高于栈顶操作符则弹出栈顶操作符加入后缀字符串列表知道栈顶操作符优先级小于当前操作符，将当前操作符进栈；
     * 操作符栈一直保证优先级递减的顺序
     * @param inOrderList
     * @return
     */
    public ArrayList<String> getPostOrder(ArrayList<String> inOrderList){
        ArrayList<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for (int i=0;i<inOrderList.size();i++){
            String tmp = inOrderList.get(i);
            if (!isOperator(tmp))
                result.add(tmp);
            else {
                switch (tmp){
                    case "(":
                        stack.push(tmp);
                        break;
                    case ")":
                        while (!stack.peek().equals("(")){
                            result.add(stack.pop());
                        }
                        stack.pop();
                        break;
                    default:
                        while (!stack.isEmpty()&&compare(stack.peek(),tmp)){
                            result.add(stack.pop());
                        }
                        stack.push(tmp);
                        break;
                }
            }
        }
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }

        return result;
    }

    public int calculate(ArrayList<String> postOrderStr){
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<postOrderStr.size();i++){
            String tmp = postOrderStr.get(i);
            if (!isOperator(tmp)){
                stack.push(Integer.parseInt(tmp));
            }else {
                int res = 0;
                Integer post = stack.pop();
                Integer pre = stack.pop();
                switch (tmp){
                    case "+":
                        res = pre + post;
                        break;
                    case "-":
                        res = pre - post;
                        break;
                    case "*":
                        res = pre * post;
                        break;
                    case "/":
                        res = pre/post;
                        break;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        CalculateNumStr c = new CalculateNumStr();
        String str = "48*((70-65)-43)+8*1";
        System.out.println(c.getStringList(str).toString());
        System.out.println(c.getPostOrder(c.getStringList(str)));
        System.out.println(c.calculate(c.getPostOrder(c.getStringList(str))));
    }
}
