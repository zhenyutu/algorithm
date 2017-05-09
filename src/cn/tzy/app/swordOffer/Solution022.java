package cn.tzy.app.swordOffer;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-5-9.
 * @author tuzhenyu
 */
public class Solution022 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.size()==0||node<minStack.peek()){
            minStack.push(node);
        }else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Solution022 s = new Solution022();
        s.push(3);
        System.out.println(s.min());
    }
}
