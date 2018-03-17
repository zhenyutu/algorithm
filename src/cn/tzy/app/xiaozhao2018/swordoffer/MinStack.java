package cn.tzy.app.xiaozhao2018.swordoffer;

import java.util.Stack;

/**
 * Created by tuzhenyu on 18-3-16.
 * @author tuzhenyu
 */
public class MinStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int val){
        if (!stack2.isEmpty()&&stack2.peek()<val){
            stack2.push(stack2.peek());
        }
        stack1.push(val);
        stack2.push(val);
    }

    public int pop(){
        stack2.pop();
        return stack1.pop();
    }

    public int getMin(){
        return stack2.peek();
    }
}
