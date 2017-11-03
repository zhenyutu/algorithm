package cn.tzy.app.swordoffer;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-11-3.
 * @author tuzhenyu
 */
public class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.size()==0||minStack.peek()>node)
            minStack.push(node);
        else
            minStack.push(stack.peek());
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
