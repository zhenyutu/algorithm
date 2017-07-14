package cn.tzy.app.coderInterviewGuide.chapter1;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-7-14.
 * @author tuzhenyu
 */
public class ReverseStack {
    private static int getAndRemoveLastElem(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty())
            return result;
        else {
            int last = getAndRemoveLastElem(stack);
            stack.push(last);
            return last;
        }

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(getAndRemoveLastElem(stack));
    }
}
