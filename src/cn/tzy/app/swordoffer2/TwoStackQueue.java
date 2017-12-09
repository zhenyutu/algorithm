package cn.tzy.app.swordoffer2;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-12-9.
 * @author tuzhenyu
 */
public class TwoStackQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        TwoStackQueue t = new TwoStackQueue();
        t.push(1);
        t.push(2);
        t.push(3);

        System.out.println(t.pop());
        System.out.println(t.pop());
        System.out.println(t.pop());
    }
}
