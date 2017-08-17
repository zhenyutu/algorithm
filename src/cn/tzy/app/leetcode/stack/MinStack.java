package cn.tzy.app.leetcode.stack;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-8-16.
 * @author tuzhenyu
 * leetcode_155
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> stackMin;

    public MinStack() {
        stack = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (stackMin.isEmpty()||stackMin.peek()>x){
            stackMin.push(x);
        }else {
            stackMin.push(stackMin.peek());
        }
    }

    public void pop() {
        stack.pop();
        stackMin.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(3);
        System.out.println(stack.getMin());
        stack.push(5);
        System.out.println(stack.getMin());
        stack.push(2);
        System.out.println(stack.getMin());
    }
}
